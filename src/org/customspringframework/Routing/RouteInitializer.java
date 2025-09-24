package org.customspringframework.Routing;

import org.customspringframework.Routing.handler.MappingHandler;
import org.customspringframework.Routing.handler.MappingHandlerFactory;
import org.customspringframework.annotation.*;
import org.customspringframework.Scanning.*;

import java.lang.reflect.Method;
import java.util.List;

public class RouteInitializer {
    private final RouteRegistry registry;
    private final MappingHandlerFactory handlerFactory = new MappingHandlerFactory();

    public RouteInitializer(RouteRegistry registry) {
        this.registry = registry;
    }

    public void initialize(String basePackage) {
        PackageClassScanner scanner = new PackageClassScanner(basePackage);
        ControllerClassFilter filter = new ControllerClassFilter(scanner.getDiscoveredClasses());
        List<Class<?>> controllers = filter.getControllerClasses();

        for (Class<?> controller : controllers) {
            String controllerPath = controller.getAnnotation(Controller.class).value();

            for (Method method : controller.getDeclaredMethods()) {
                for (MappingHandler handler : handlerFactory.getHandlers()) {
                    if (handler.supports(method)) {
                        handler.registerRoute(method, controllerPath, registry);
                        break; // stop after first matching handler
                    }
                }
            }
        }
    }

    public void initialize(String[] basePackages) {
        for (String basePackage : basePackages) initialize(basePackage);
    }
}

