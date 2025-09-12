package org.customspringframework.boot;

import java.util.*;

public class ApplicationContext {
    private final Class<?> applicationClass;
    private final Map<Class<?>, Object> beans = new HashMap<>();
    private Set<String> basePackages = new HashSet<>();

    public ApplicationContext(Class<?> applicationClass) {
        this.applicationClass = applicationClass;
    }

    public Class<?> getApplicationClass() {
        return applicationClass;
    }

    public void setBasePackages(Set<String> packages) {
        this.basePackages = packages;
    }

    public Set<String> getBasePackages() {
        return basePackages;
    }

    public void registerBean(Class<?> clazz, Object instance) {
        beans.put(clazz, instance);
    }

    public <T> T getBean(Class<T> clazz) {
        return clazz.cast(beans.get(clazz));
    }
}
