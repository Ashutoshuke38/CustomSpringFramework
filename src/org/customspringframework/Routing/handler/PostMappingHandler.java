package org.customspringframework.Routing.handler;

import org.customspringframework.Routing.RouteRegistry;
import org.customspringframework.annotation.PostMapping;

import java.lang.reflect.Method;

public class PostMappingHandler implements MappingHandler {

    @Override
    public boolean supports(Method method) {
        return method.isAnnotationPresent(PostMapping.class);
    }

    @Override
    public void registerRoute(Method method, String controllerPath, RouteRegistry registry) {
        PostMapping mapping = method.getAnnotation(PostMapping.class);
        registry.register("POST", controllerPath, mapping.value(), method, mapping);
    }
}

