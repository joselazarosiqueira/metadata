package net.sf.esfinge.container.processor.method;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;


public class ContainerProcessorsTest {

	@Test
	public void test() throws Exception {
		Container container = new Container();
		AnnotationReader a1 = new AnnotationReader();
		container = a1.readingAnnotationsTo(Dominio.class, container.getClass());
		//assertNotNull(container.getMap().size());
		assertNotEquals(0, container.getMap().size());
		
		//assert();			
	}

}
