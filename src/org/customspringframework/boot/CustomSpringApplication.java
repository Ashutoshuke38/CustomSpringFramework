package org.customspringframework.boot;

import org.customspringframework.annotation.ComponentScan;
import org.customspringframework.annotation.Validators.StartUpValidator;
import org.customspringframework.Core.RouteInitializer;
import org.customspringframework.Routing.RouteRegistry;
import org.customspringframework.Routing.RouteRegistryHolder;
import org.customspringframework.Server.ApplicationServer;

public class CustomSpringApplication {

    public static void Run(Class<?> applicationClass)
    {
        // Check if class has requied anotations
        new StartUpValidator().validate(applicationClass);
        String[] basePackages = applicationClass.getAnnotation(ComponentScan.class).basePackages();
        System.out.println("Bootstrapping " + applicationClass.getName() + "...");

        RouteRegistry routeRegistry = new RouteRegistry();
        new RouteInitializer(routeRegistry).initialize(basePackages);
        RouteRegistryHolder.initialize(routeRegistry);
        
        try {
            ApplicationServer server = new ApplicationServer(8081);
            server.createContexts();
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


}

class SystemMain {
    public static void main(String[] args) {

    }
}



