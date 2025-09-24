package org.customspringframework.Routing.handler;

import org.customspringframework.Routing.RouteRegistry;
import org.customspringframework.annotation.PutMapping;

import java.lang.reflect.Method;

public class PutMappingHandler implements MappingHandler {

    @Override
    public boolean supports(Method method) {
        return method.isAnnotationPresent(PutMapping.class);
    }

    @Override
    public void registerRoute(Method method, String controllerPath, RouteRegistry registry) {
        PutMapping mapping = method.getAnnotation(PutMapping.class);
        registry.register("POST", controllerPath, mapping.value(), method);
    }
}

