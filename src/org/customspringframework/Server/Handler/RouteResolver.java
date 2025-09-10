package org.customspringframework.Server.Handler;

import org.customspringframework.Routing.Route;

public interface RouteResolver {
    Route resolve(String method, String path);
}
