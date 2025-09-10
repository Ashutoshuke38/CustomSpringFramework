package org.customspringframework.Server.Handler.impl;

import org.customspringframework.annotation.PathVariable;
import org.customspringframework.Core.Coverter.ConversionService;
import org.customspringframework.Routing.Route;
import org.customspringframework.Server.Handler.ArgumentResolver;

import java.lang.reflect.Parameter;
import java.util.regex.Matcher;

public class PathVariableArgumentResolver implements ArgumentResolver {
    @Override
    public Object[] resolveArguments(Route route, String routeKey) {
        Parameter[] params = route.getMethod().getParameters();
        Object[] args = new Object[params.length];
        Matcher matcher = route.getMatcher(routeKey);

        if (!matcher.matches()) return args;

        for (int i = 0; i < params.length; i++) {
            PathVariable pv = params[i].getAnnotation(PathVariable.class);
            if (pv != null) {
              String pathVariableName =  pv.value().isEmpty() ? params[i].getName() : pv.value();
                int varIndex = route.getVariableNames().indexOf(pathVariableName);
                if (varIndex != -1) {
                    String pathVar = matcher.group(varIndex + 1); // group is 1-based
                    args[i] = ConversionService.convert(params[i].getType(), pathVar);
                }
            }
        }
        return args;
    }
}
