package net.sf.esfinge.metadata.container;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import net.sf.esfinge.metadata.annotation.container.AnnotationReadingConfig;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.FieldProcessors;
import net.sf.esfinge.metadata.annotation.container.ProcessFields;
import net.sf.esfinge.metadata.annotation.container.ProcessorType;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;


@ContainerFor(ContainerTarget.TYPE)
public class MetadataContainer {
	
	@ElementName
	private String containerName;
	
	@ReflectionReference
	private Class containerClass;
	
	@ProcessFields
	private List<FieldMetadataContainer> fields;

	
	//private Map<Field, AnnotationReadingProcessor> objectToExecute;

	
	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public Class getContainerClass() {
		return containerClass;
	}

	public void setContainerClass(Class containerClass) {
		this.containerClass = containerClass;
	}
	
	

	//public Map<Field, AnnotationReadingProcessor> getObjectToExecute() {
	//	return objectToExecute;
	//}

	//public void setObjectToExecute(Map<Field, AnnotationReadingProcessor> objectToExecute) {
		//this.objectToExecute = objectToExecute;
		//}


	
	@Override
	public String toString() {
		return "MetadataContainer [containerName=" + containerName + ", containerClass=" + containerClass
				+ ", objectToExecute=" + fields+ "]";
	}

	public List<FieldMetadataContainer> getFields() {
		return fields;
	}

	public void setFields(List<FieldMetadataContainer> fields) {
		this.fields = fields;
	}

	
}
