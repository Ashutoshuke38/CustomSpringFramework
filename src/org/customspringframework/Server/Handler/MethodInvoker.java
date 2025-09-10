package org.customspringframework.Server.Handler;

import org.customspringframework.Routing.Route;

public interface MethodInvoker {
    Object invoke(Route route, Object[] args) throws Exception;
}
