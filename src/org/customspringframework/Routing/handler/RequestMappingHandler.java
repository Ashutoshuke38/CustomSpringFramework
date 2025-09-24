package org.customspringframework.Routing.handler;

import org.customspringframework.Routing.RouteRegistry;
import org.customspringframework.annotation.RequestMapping;

import java.lang.reflect.Method;

public class RequestMappingHandler implements MappingHandler {

    @Override
    public boolean supports(Method method) {
        return method.isAnnotationPresent(RequestMapping.class);
    }

    @Override
    public void registerRoute(Method method, String controllerPath, RouteRegistry registry) {
        RequestMapping mapping = method.getAnnotation(RequestMapping.class);
        String httpMethod = mapping.method().name(); // e.g., GET/POST
        registry.register(httpMethod, controllerPath, mapping.value(), method);
    }
}

