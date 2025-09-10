package org.customspringframework.Scanning;

import org.customspringframework.annotation.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Filters only those classes that are annotated with @Controller.
 */
public class ControllerClassFilter {

    private final List<Class<?>> controllerClasses;

    public ControllerClassFilter(List<Class<?>> classes) {
        this.controllerClasses = filterControllers(classes);
    }

    private List<Class<?>> filterControllers(List<Class<?>> classes) {
        List<Class<?>> result = new ArrayList<>();
        for (Class<?> cls : classes) {
            if (cls.isAnnotationPresent(Controller.class)) {
                result.add(cls);
            }
        }
        return result;
    }

    public List<Class<?>> getControllerClasses() {
        return controllerClasses;
    }
}
