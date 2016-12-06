package net.sf.esfinge.metadata.properties.containers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ElementPropertyWithoutAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerIgnore {
	@ElementPropertyWithoutAnnotation(IgnoreInComparison.class)
	private List<PropertyDescriptor> properties;
	
	@ElementName
	private String idProp;

	public List<PropertyDescriptor> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyDescriptor> properties) {
		this.properties = properties;
	}

	public String getIdProp() {
		return idProp;
	}

	public void setIdProp(String idProp) {
		this.idProp = idProp;
	}
	
	
}
