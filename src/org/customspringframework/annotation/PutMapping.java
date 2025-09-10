package org.customspringframework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Step 1: Declare the annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime via reflection
@Target(ElementType.METHOD)         // Can be applied to methods
public @interface PutMapping {
    String value();                 // Annotation element
}
