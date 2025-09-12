package org.customspringframework.boot;

import java.util.*;

public class ApplicationBootstrapper {

    private final List<ApplicationContextInitializer> initializers = new ArrayList<>();
    private final List<ApplicationRunner> runners = new ArrayList<>();

    public ApplicationBootstrapper withInitializer(ApplicationContextInitializer initializer) {
        this.initializers.add(initializer);
        return this;
    }

    public ApplicationBootstrapper withRunner(ApplicationRunner runner) {
        this.runners.add(runner);
        return this;
    }

    public void bootstrap(Class<?> applicationClass, String[] args) {
        ApplicationContext context = new ApplicationContext(applicationClass);

        for (ApplicationContextInitializer initializer : initializers) {
            initializer.initialize(context);
        }

        System.out.println("Bootstrapping " + applicationClass.getName() + "...");

        for (ApplicationRunner runner : runners) {
            runner.run(context, args);
        }
    }
}
