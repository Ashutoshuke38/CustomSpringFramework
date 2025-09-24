package org.customspringframework.annotation;

import org.customspringframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Step 1: Declare the annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime via reflection
@Target(ElementType.METHOD)         // Can be applied to methods
public @interface GetMapping {
    String value();                 // Annotation element
    String produces() default MediaType.APPLICATION_JSON;
}

