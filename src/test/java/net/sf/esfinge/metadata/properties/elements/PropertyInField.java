package net.sf.esfinge.metadata.properties.elements;

import net.sf.esfinge.metadata.properties.annotation.PropertyContrainAnnotation;

public class PropertyInField {
	int prop1;

	@PropertyContrainAnnotation
	int prop2;
	
	public int getProp1() {
		return prop1;
	}
	public void setProp1(int prop1) {
		this.prop1 = prop1;
	}
	
	public int getProp2() {
		return prop1;
	}
	public void setProp2(int prop1) {
		this.prop1 = prop1;
	}



}
