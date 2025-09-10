package org.customspringframework.Core;

import org.customspringframework.annotation.*;
import org.customspringframework.Routing.RouteRegistry;
import org.customspringframework.Scanning.*;

import java.lang.reflect.Method;
import java.util.List;

public class RouteInitializer {
    private final RouteRegistry registry;

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
                if (method.isAnnotationPresent(GetMapping.class)) {
                    registry.register("GET", controllerPath, method.getAnnotation(GetMapping.class).value(), method);
                } else if (method.isAnnotationPresent(PostMapping.class)) {
                    registry.register("POST", controllerPath, method.getAnnotation(PostMapping.class).value(), method);
                } else if (method.isAnnotationPresent(PutMapping.class)) {
                    registry.register("PUT", controllerPath, method.getAnnotation(PutMapping.class).value(), method);
                } else if (method.isAnnotationPresent(DeleteMapping.class)) {
                    registry.register("DELETE", controllerPath, method.getAnnotation(DeleteMapping.class).value(), method);
                }
            }
        }
    }

    public void initialize(String[] basePackages) {
        for (String basePackage : basePackages) { initialize(basePackage); }
    }
}
