package org.customspringframework.boot.runners;

import org.customspringframework.boot.ApplicationContext;
import org.customspringframework.boot.ApplicationRunner;
import org.customspringframework.Core.RouteInitializer;
import org.customspringframework.Routing.RouteRegistry;
import org.customspringframework.Routing.RouteRegistryHolder;

public class RouteInitializerRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationContext context, String[] args) {
        RouteRegistry registry = new RouteRegistry();
        new RouteInitializer(registry).initialize(
                context.getBasePackages().toArray(new String[0])
        );
        RouteRegistryHolder.initialize(registry);
    }
}
