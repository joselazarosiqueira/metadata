package org.esfinge.metadata.validate.field.test;

import static org.junit.Assert.assertTrue;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.junit.Test;

public class TestFieldOnly {	
	
	@Test
	public void testWithSuccess() throws Exception {		
		MetadataValidator.validateMetadataOn(Person.class);
		assertTrue(true);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithError() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithError.class);
	}	
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorFieldVisibilityForbidden() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorFieldVisibilityForbidden.class);
	}	
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorFieldVisibilityRequired() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorFieldVisibilityRequired.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorFinalFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorFinalFieldOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorInstanceFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorInstanceFieldOnly.class);
	}

	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorStaticFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorStaticFieldOnly.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorTransientFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorTransientFieldOnly.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorValidFieldTypes() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorValidFieldTypes.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorVolatileFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorVolatileFieldOnly.class);
	}

}
