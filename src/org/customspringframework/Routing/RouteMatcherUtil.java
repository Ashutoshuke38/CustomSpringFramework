package org.customspringframework.Routing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RouteMatcherUtil {

    public static List<String> extractVariableNames(String routePattern) {
        List<String> variableNames = new ArrayList<>();
        Matcher varMatcher = Pattern.compile("\\{([^/]+)}").matcher(routePattern);
        while (varMatcher.find()) {
            variableNames.add(varMatcher.group(1));
        }
        return variableNames;
    }

    public static Pattern buildPatternFromRoute(String routePattern) {
        String regex = routePattern.replaceAll("\\{[^/]+}", "([^/]+)");
        return Pattern.compile("^" + regex + "$");
    }

    public static boolean matches(String routePattern, String path) {
        Pattern pattern = buildPatternFromRoute(routePattern);
        return pattern.matcher(path).matches();
    }

    public static Matcher getMatcher(String routePattern, String path) {
        Pattern pattern = buildPatternFromRoute(routePattern);
        return pattern.matcher(path);
    }
}
