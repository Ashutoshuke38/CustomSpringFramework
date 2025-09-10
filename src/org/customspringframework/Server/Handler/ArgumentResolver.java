package org.customspringframework.Server.Handler;

import org.customspringframework.Routing.Route;

public interface ArgumentResolver {
    Object[] resolveArguments(Route route, String routeKey);
}

