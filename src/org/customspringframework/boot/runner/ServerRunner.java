package org.customspringframework.boot.runners;

import org.customspringframework.boot.ApplicationContext;
import org.customspringframework.boot.ApplicationRunner;
import org.customspringframework.Server.ApplicationServer;

public class ServerRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationContext context, String[] args) {
        try {
            ApplicationServer server = new ApplicationServer(8081);
            server.createContexts();
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
