package net.sf.esfinge.metadata.validate.field.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithFieldVisibilityForbidden;
import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithFieldVisibilityRequired;
import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithFinalFieldOnly;
import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithInstanceFieldOnly;
import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithStaticFieldOnly;
import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithTransientFieldOnly;
import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithValidFieldTypes;
import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithVolatileFieldOnly;

public class Person {
	
	@OneAnnotationWithFieldVisibilityForbidden
	@OneAnnotationWithStaticFieldOnly
	private static long staticValue = 892832;	
	@OneAnnotationWithStaticFieldOnly
	private static int otherStaticValue = 0;	
	
	@OneAnnotationWithInstanceFieldOnly
	@OneAnnotationWithFinalFieldOnly
	private final String finalValue = "";
	@OneAnnotationWithFieldVisibilityRequired
	@OneAnnotationWithFinalFieldOnly
	private final double otherFinalValue = 4.2;	
	
	@OneAnnotationWithFieldVisibilityForbidden
	@OneAnnotationWithTransientFieldOnly
	private transient byte transientValue = 2;	
	@OneAnnotationWithTransientFieldOnly
	private transient boolean otherTransientValue = false;	
	
	@OneAnnotationWithVolatileFieldOnly
	private volatile String volatileValue = "";
	@OneAnnotationWithInstanceFieldOnly
	@OneAnnotationWithVolatileFieldOnly
	private volatile float otherVolatileValue = 3.5f;
	
	@OneAnnotationWithFieldVisibilityRequired
	private String cpf;
	
	@OneAnnotationWithValidFieldTypes
	private String name;
	
	@OneAnnotationWithValidFieldTypes
	private int age;	
		
	@OneAnnotationWithValidFieldTypes
	private List<Integer> someList = new LinkedList<Integer>();
	
	@OneAnnotationWithValidFieldTypes
	private ArrayList<Float> otherList = new ArrayList<Float>();
	
	
	public Person(String name, String cpf, int age) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
	}
	
	
	@OneAnnotationWithFieldVisibilityForbidden
	public String getName() {
		return name;
	}
	@OneAnnotationWithFieldVisibilityRequired
	public void setName(String name) {
		this.name = name;
	}
	@OneAnnotationWithFinalFieldOnly
	public String getCpf() {
		return cpf;
	}
	@OneAnnotationWithInstanceFieldOnly
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@OneAnnotationWithStaticFieldOnly
	public int getAge() {
		return age;
	}
	@OneAnnotationWithTransientFieldOnly
	public void setAge(int age) {
		this.age = age;
	}
	@OneAnnotationWithValidFieldTypes
	public List<Integer> getSomeList() {
		return someList;
	}
	@OneAnnotationWithVolatileFieldOnly
	public void setSomeList(List<Integer> someList) {
		this.someList = someList;
	}
	
}