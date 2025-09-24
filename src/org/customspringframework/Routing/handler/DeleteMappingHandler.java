package org.customspringframework.Routing.handler;

import org.customspringframework.Routing.RouteRegistry;
import org.customspringframework.annotation.DeleteMapping;

import java.lang.reflect.Method;

public class DeleteMappingHandler implements MappingHandler {

    @Override
    public boolean supports(Method method) {
        return method.isAnnotationPresent(DeleteMapping.class);
    }

    @Override
    public void registerRoute(Method method, String controllerPath, RouteRegistry registry) {
        DeleteMapping mapping = method.getAnnotation(DeleteMapping.class);
        registry.register("POST", controllerPath, mapping.value(), method, mapping);
    }
}

