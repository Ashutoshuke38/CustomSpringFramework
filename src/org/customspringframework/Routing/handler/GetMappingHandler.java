package org.customspringframework.Routing.handler;

import org.customspringframework.Routing.RouteRegistry;
import org.customspringframework.annotation.GetMapping;

import java.lang.reflect.Method;

public class GetMappingHandler implements MappingHandler {

    @Override
    public boolean supports(Method method) {
        return method.isAnnotationPresent(GetMapping.class);
    }

    @Override
    public void registerRoute(Method method, String controllerPath, RouteRegistry registry) {
        GetMapping mapping = method.getAnnotation(GetMapping.class);
        registry.register("GET", controllerPath, mapping.value(), method,mapping);
    }
}

