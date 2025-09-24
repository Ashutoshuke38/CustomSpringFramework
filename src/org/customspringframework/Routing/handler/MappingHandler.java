package org.customspringframework.Routing.handler;

import java.lang.reflect.Method;
import org.customspringframework.Routing.RouteRegistry;

public interface MappingHandler {
    boolean supports(Method method);
    void registerRoute(Method method, String controllerPath, RouteRegistry registry);
}
