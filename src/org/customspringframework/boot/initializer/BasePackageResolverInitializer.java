package org.customspringframework.boot.initializers;

import org.customspringframework.boot.*;
import org.customspringframework.annotation.ComponentScan;

import java.util.*;

public class BasePackageResolverInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ApplicationContext context) {
        Set<String> basePackages = new HashSet<>();
        Class<?> applicationClass = context.getApplicationClass();

        String pkg = applicationClass.getPackageName();
        if (!pkg.isEmpty()) basePackages.add(pkg);

        if (applicationClass.isAnnotationPresent(ComponentScan.class)) {
            String[] scanPkgs = applicationClass.getAnnotation(ComponentScan.class).basePackages();
            Collections.addAll(basePackages, scanPkgs);
        }

        context.setBasePackages(basePackages);
    }
}
