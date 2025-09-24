package org.customspringframework.Server.Handler.impl;

import org.customspringframework.annotation.DeleteMapping;
import org.customspringframework.annotation.GetMapping;
import org.customspringframework.annotation.PostMapping;
import org.customspringframework.annotation.PutMapping;

import java.lang.annotation.Annotation;

public class MappingAttributeResolver {
    public static String resolveProduces(Annotation annotation) {
        if (annotation instanceof GetMapping) {
            return ((GetMapping) annotation).produces();
        }
        if (annotation instanceof PutMapping) {
            return ((PutMapping) annotation).produces();
        }
        if (annotation instanceof DeleteMapping) {
            return ((DeleteMapping) annotation).produces();
        }
        if (annotation instanceof PostMapping) {
            return ((PostMapping) annotation).produces();
        }
        return null;
    }

}
