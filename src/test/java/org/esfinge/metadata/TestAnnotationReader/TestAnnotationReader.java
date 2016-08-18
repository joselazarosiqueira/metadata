package org.esfinge.metadata.TestAnnotationReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import static org.esfinge.metadata.AnnotationReader.readingAnnotationsTo;
import org.junit.Test;

public class TestAnnotationReader {

	// Todos os elementos ok
	@Test
	public void CT00() throws Exception {
		CT0Container container = (CT0Container) readingAnnotationsTo(Dominio.class, CT0Container.class);
		assertEquals("dominio", container.getNomeTabela());
	}

	
	@Test
	public void CT01() throws Exception {

		CT1Container container = (CT1Container) readingAnnotationsTo(Dominio.class, CT1Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());
	}

	// Falta 1 elemento
	// isEntidadeFalse
	@Test
	public void CT02() throws Exception {

		CT2Container container = (CT2Container) readingAnnotationsTo(Dominio.class, CT2Container.class);
		assertTrue(!container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());
	}

	// Nome da classe is NULL
	@Test
	public void CT03() throws Exception {

		
		CT3Container container = (CT3Container) readingAnnotationsTo(Dominio.class, CT3Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertNull(container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());

	}

	// class is null
	@Test
	public void CT04() throws Exception {

		CT4Container container = (CT4Container) readingAnnotationsTo(Dominio.class, CT4Container.class);
		assertTrue(container.isEntidade());
		assertNull(container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());

	}

	// class is null
	@Test
	public void CT05() throws Exception {

		CT5Container container = (CT5Container) readingAnnotationsTo(Dominio.class, CT5Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertNull(container.getNomeTabela());

	}

	@Test
	public void CT06() throws Exception {

		CT6Container container = (CT6Container) readingAnnotationsTo(Dominio.class, CT6Container.class);
		assertTrue(container.isEntidade());

	}

	@Test
	public void CT07() throws Exception {

		CT7Container container = (CT7Container) readingAnnotationsTo(Dominio.class, CT7Container.class);
		assertEquals(Dominio.class.getName(), container.getNomeClasse());

	}

	@Test
	public void CT08() throws Exception {

		CT8Container container = (CT8Container) readingAnnotationsTo(Dominio.class, CT8Container.class);
		assertEquals(Dominio.class, container.getClassValue());

	}

	@Test
	public void CT09() throws Exception {

		CT9Container container = (CT9Container) readingAnnotationsTo(Dominio.class, CT9Container.class);
		assertEquals("dominio", container.getNomeTabela());
	}

	@Test
	public void CT10() throws Exception {

		CT10Container container = (CT10Container) readingAnnotationsTo(Dominio.class, CT10Container.class);
		assertNull("Table Name is Null", container.getNomeTabela());
	}

	@Test
	public void CT012() throws Exception {

		CT12Container container = (CT12Container) readingAnnotationsTo(Dominio.class, CT12Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());

		int sun = 0;
		for (MethodContainer m1 : container.getLista()) {
			if (m1.isToProcess()) {
				sun++;
			}
		}
		assertEquals(1, sun);
	}

	@Test
	public void CT013() throws Exception {

		CT13Container container = (CT13Container) readingAnnotationsTo(Dominio.class, CT13Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());

		int sun = 0;
		for (MethodContainer2 m1 : container.getLista()) {

			if (m1.isToProcess()) {
				sun++;
			}
		}
		assertEquals(0, sun);

	}

	@Test
	public void CT014() throws Exception {

		Container014 container = (Container014) readingAnnotationsTo(Dominio.class, Container014.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());
		assertNotNull(container.getListaMetodsWith());
		assertNotNull(container.getSetMethodsWith());
		
		int sun = 0;
		for (MethodContainer m1 : container.getListaMethods()) {
			if (m1.isToProcess()) {
				sun++;
			}
		}
		assertEquals(1, sun);
		assertEquals(2, container.getListaMethods().size());
		assertEquals(1, container.getListaMetodsWith().size());
		assertEquals(1, container.getSetMethodsWith().size());

		int sun2 = 0;
		for (FieldContainer m1 : container.getListaFields()) {
			if (m1.isToProcess()) {
				sun2++;
			}
		}
		assertEquals(1, sun2);
	}
	
	@Test
	public void CT015() throws Exception {

		Container container = (Container) readingAnnotationsTo(Dominio.class, Container.class);
			
	}


}
