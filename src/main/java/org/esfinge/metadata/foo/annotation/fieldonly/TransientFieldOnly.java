package org.esfinge.metadata.foo.annotation.fieldonly;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.annotation.validator.ToValidate;
import org.esfinge.metadata.foo.validator.implementation.ValidatorTransientFieldOnly;

@ToValidate(validationClass = ValidatorTransientFieldOnly.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface TransientFieldOnly {
	boolean ignoreWhenNotField() default true;
}
