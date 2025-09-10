package org.customspringframework.Routing;

public class RouteRegistryHolder {

    private static RouteRegistry routeRegistry;

    private RouteRegistryHolder() {
        // Prevent instantiation
    }

    public static void initialize(RouteRegistry registry) {
        if (routeRegistry != null) {
            throw new IllegalStateException("RouteRegistry is already initialized.");
        }
        routeRegistry = registry;
    }

    public static RouteRegistry get() {
        if (routeRegistry == null) {
            throw new IllegalStateException("RouteRegistry has not been initialized.");
        }
        return routeRegistry;
    }
}
