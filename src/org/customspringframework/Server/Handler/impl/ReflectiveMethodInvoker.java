package org.customspringframework.Server.Handler.impl;

import org.customspringframework.Routing.Route;
import org.customspringframework.Server.Handler.MethodInvoker;

public class ReflectiveMethodInvoker implements MethodInvoker {
    @Override
    public Object invoke(Route route, Object[] args) throws Exception {
        Object instance = route.getMethod().getDeclaringClass().getDeclaredConstructor().newInstance();
        return route.getMethod().invoke(instance, args);
    }
}
