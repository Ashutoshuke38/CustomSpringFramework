package org.customspringframework.boot;

import org.customspringframework.boot.initializers.BasePackageResolverInitializer;
import org.customspringframework.boot.runners.RouteInitializerRunner;
import org.customspringframework.boot.runners.ServerRunner;

public class CustomSpringApplication {
    public static void run(Class<?> applicationClass, String... args) {
        new ApplicationBootstrapper()
                .withInitializer(new BasePackageResolverInitializer())
                .withRunner(new RouteInitializerRunner())
                .withRunner(new ServerRunner())
                .bootstrap(applicationClass, args);
    }
}


class SystemMain {
    public static void main(String[] args) {

    }
}



