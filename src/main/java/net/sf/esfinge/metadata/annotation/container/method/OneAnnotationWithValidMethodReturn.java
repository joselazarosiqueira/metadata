package net.sf.esfinge.metadata.annotation.container.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.method.ValidMethodReturn;

@ValidMethodReturn(validTypesToReturn = {int.class, Integer.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithValidMethodReturn {
}