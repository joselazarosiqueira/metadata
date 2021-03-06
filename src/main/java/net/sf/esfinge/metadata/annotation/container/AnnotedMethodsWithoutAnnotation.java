package net.sf.esfinge.metadata.annotation.container;


import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.AnnotedMethodsWithoutAnnotationReadingProcessor;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(AnnotedMethodsWithoutAnnotationReadingProcessor.class)
@SearchOnEnclosingElements

@ValidFieldType({List.class, Set.class,Map.class})
public @interface AnnotedMethodsWithoutAnnotation {
	Class<? extends Annotation> value();
}
