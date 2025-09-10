package org.customspringframework.Server.Handler.impl;

import org.customspringframework.Routing.Route;
import org.customspringframework.Routing.RouteRegistryHolder;
import org.customspringframework.Server.Handler.RouteResolver;

public class DefaultRouteResolver implements RouteResolver {
    @Override
    public Route resolve(String method, String path) {
        String routeKey = method + ":" + path;
        return RouteRegistryHolder.get().getHandler(routeKey);
    }
}
