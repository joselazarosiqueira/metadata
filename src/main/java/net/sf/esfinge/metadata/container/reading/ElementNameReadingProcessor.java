package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ElementNameReadingProcessor implements AnnotationReadingProcessor {
	
	private String containerAnnotatedField;

	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata) {
		containerAnnotatedField = ((Field) elementWithMetadata).getName();
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container,ContainerTarget target) throws AnnotationReadingException {
		try {
			FindFields(elementWithMetadata, container, target);
			//
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the element name:",e);
		}
	}

	private void FindFields(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(target == ContainerTarget.TYPE){
			Class<?> class1 = (Class<?>) elementWithMetadata;
			setProperty(container,containerAnnotatedField,class1.getName());
		}
		else if(target == ContainerTarget.FIELDS){
			Field field = (Field) elementWithMetadata;
			setProperty(container,containerAnnotatedField,field.getName());

		}
		else if(target == ContainerTarget.METHODS){
			Method method = (Method) elementWithMetadata;
			setProperty(container,containerAnnotatedField,method.getName());
		}
		else if(target == ContainerTarget.ALL)
		{
			if(elementWithMetadata.getClass().equals(Method.class)){
				Method method = (Method) elementWithMetadata;
				setProperty(container,containerAnnotatedField,method.getName());
			}
			else if(elementWithMetadata.getClass().equals(Field.class)){
				Field field = (Field) elementWithMetadata;
				setProperty(container,containerAnnotatedField,field.getName());
			}
			else
			{
				Class<?> class1 = (Class<?>) elementWithMetadata;
				setProperty(container,containerAnnotatedField,class1.getName());
			}

		}
	}

}
