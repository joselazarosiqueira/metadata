package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ReflectionReferenceReadingProcessor implements AnnotationReadingProcessor {
	
	private String containerAnnotatedField;
	private Field fieldAnn;

	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata) {
		fieldAnn = (Field) elementWithMetadata;
		containerAnnotatedField =  fieldAnn.getName();
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget enumStr) throws AnnotationReadingException {
		try {
			setProperty(container, containerAnnotatedField,elementWithMetadata);
		
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the file "+elementWithMetadata+"in "+containerAnnotatedField,e);
		}
	}

}