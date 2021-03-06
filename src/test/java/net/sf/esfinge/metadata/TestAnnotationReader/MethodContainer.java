package net.sf.esfinge.metadata.TestAnnotationReader;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.METHODS)
public class MethodContainer {

	
	@ContainsAnnotation(Procesos.class)
	private boolean toProcess;
	
	@ElementName
	public String metodo;

	public boolean isToProcess() {
		return toProcess;
	}

	public void setToProcess(boolean toProcess) {
		this.toProcess = toProcess;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	@Override
	public String toString() {
		return "MethodContainer [toProcess=" + toProcess + ", metodo=" + metodo + "]";
	}
	
	
	
}
