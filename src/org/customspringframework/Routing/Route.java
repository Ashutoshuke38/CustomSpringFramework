package org.customspringframework.Routing;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Route {
    final Pattern pattern;
    final Method method;
    final List<String> variableNames;
    final Annotation mappingAnnotation;

    public Route(Pattern pattern, Method method, List<String> variableNames, Annotation mappingAnnotation) {
        this.pattern = pattern;
        this.method = method;
        this.variableNames = variableNames;
        this.mappingAnnotation = mappingAnnotation;
    }
    public Route(Pattern pattern, Method method, List<String> variableNames) {
        this(pattern, method, variableNames, null);
    }

    public boolean matches(String path) {
        return pattern.matcher(path).matches();
    }

    public Matcher getMatcher(String path) {
        return pattern.matcher(path);
    }

    public Method getMethod() {
        return method;
    }

    public List<String> getVariableNames() {
        return variableNames;
    }

    public Annotation getMappingAnnotation() { return mappingAnnotation; }
}
