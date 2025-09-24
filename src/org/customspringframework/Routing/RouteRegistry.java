package org.customspringframework.Routing;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RouteRegistry {

    private final List<Route> routes = new ArrayList<>();

    public void register(String httpMethod, String controllerPath, String routePath, Method method) {
        register(httpMethod, controllerPath, routePath, method, null);
    }

    public void register(String httpMethod, String controllerPath, String routePath, Method method, Annotation mappingAnnotation)
    {
        String routePattern = httpMethod + ":" + controllerPath + routePath;

        List<String> variableNames = RouteMatcherUtil.extractVariableNames(routePattern);
        Pattern pattern = RouteMatcherUtil.buildPatternFromRoute(routePattern);

        routes.add(new Route(pattern, method, variableNames, mappingAnnotation));
    }

    public Route getHandler(String path) {
        for (Route route : routes) {
            if (route.matches(path)) {
                return route;
            }
        }
        return null;
    }
}
