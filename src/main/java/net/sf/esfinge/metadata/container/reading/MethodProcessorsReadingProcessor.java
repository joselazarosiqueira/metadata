package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;
import net.sf.esfinge.metadata.annotation.container.ProcessorPerMethod;
import net.sf.esfinge.metadata.annotation.container.ProcessorType;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class MethodProcessorsReadingProcessor implements AnnotationReadingProcessor {

	private Field fieldAnnoted;
	private Map<Object, Object> mapReturn,map;
	private ProcessorPerMethod processors;
	private Class<? extends Annotation> processorsAnnotationClass;
	ParameterizedType fieldGenericType;
	private Object returnInvoke;

	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata) throws AnnotationValidationException {
		fieldAnnoted = (Field) elementWithMetadata;
		processors = (ProcessorPerMethod) an;
		processorsAnnotationClass = processors.configAnnotation();
		fieldGenericType = (ParameterizedType) fieldAnnoted.getGenericType();
		map = new HashMap<>();
		mapReturn = new HashMap<>();
	} 

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		try {
			if (elementWithMetadata instanceof Class) {
				Class clazz = (Class) elementWithMetadata;
				Class[] inter = clazz.getInterfaces();
				if (inter.length > 0) {
					for (Class class1 : inter) {
						for (Method methodOfClazz : class1.getDeclaredMethods()) {
							for (Annotation annotation : methodOfClazz.getDeclaredAnnotations()) {
								// TODO Refactor total
								for (Annotation processorAnnotation : AnnotationFinder
										.findAnnotation(annotation.annotationType(), processorsAnnotationClass)) {
									// pega o class do value dessa anotation
									Class<?> valueClass = (Class<?>) processorAnnotation.getClass()
											.getDeclaredMethod("value").invoke(processorAnnotation);
									// cria um objeto dessa classe e invoca o
									// @InitProcessor
									Object objectToInvoke = valueClass.newInstance();
									findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation,
											valueClass, objectToInvoke);
									map.put(methodOfClazz, objectToInvoke);

										mapReturn.put(methodOfClazz,returnInvoke);


								}
							}
						}

					}

				} else {
					for (Method methodOfClazz : clazz.getDeclaredMethods()) {
						for (Annotation annotation : methodOfClazz.getDeclaredAnnotations()) {
							Annotation processorAnnotation = annotation.annotationType()
									.getAnnotation(processorsAnnotationClass);
							Class<?> valueClass = (Class<?>) processorAnnotation.getClass().getDeclaredMethod("value")
									.invoke(processorAnnotation);
							// cria um objeto dessa classe e invoca o
							// @InitProcessor
							Object objectToInvoke = valueClass.newInstance();
							findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation, valueClass,
									objectToInvoke);

								map.put(methodOfClazz, objectToInvoke);


								mapReturn.put(methodOfClazz,returnInvoke);


						}
					}

				}

			}
			
			if(processors.type() == ProcessorType.READER_IS_PROCESSOR){
				setProperty(container, fieldAnnoted.getName(), map);

			}
			else if(processors.type() == ProcessorType.READER_RETURNS_PROCESSOR){
				setProperty(container, fieldAnnoted.getName(), mapReturn);
			}
			
		} catch (Exception e) {
			throw new AnnotationReadingException("===========" + e);
		}

	}

	private void findDeclaredAnnotationOnInterface(AnnotatedElement elementWithMetadata, Object container,
			Annotation annotation, Class<?> valueClass, Object objectToInvoke)
			throws IllegalAccessException, InvocationTargetException {
		for (Method methodToInvoke : valueClass.getInterfaces()[0].getDeclaredMethods()) {
			if (methodToInvoke.isAnnotationPresent(ExecuteProcessor.class)) {
				executeParameters(elementWithMetadata, container, annotation, objectToInvoke, methodToInvoke);
			}
		}
	}

	private void executeParameters(AnnotatedElement elementWithMetadata, Object container, Annotation annotation,
			Object objectToInvoke, Method methodToInvoke) throws IllegalAccessException, InvocationTargetException {
		Object[] args = new Object[methodToInvoke.getParameters().length];
		int cont = 0;
		for (Parameter p1 : methodToInvoke.getParameters()) {
			if (p1.getType().equals(Annotation.class)) {
				args[cont] = annotation;
			} else if (p1.getType().equals(AnnotatedElement.class)) {
				args[cont] = elementWithMetadata;
			} else if (p1.getType().equals(container.getClass())) {
				args[cont] = container;
			}
			cont++;
		}
		returnInvoke = methodToInvoke.invoke(objectToInvoke, args);
	}
}
