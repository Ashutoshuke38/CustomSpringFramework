package org.customspringframework.Server;

import org.customspringframework.Server.Handler.RequestHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ApplicationServer {
    private final HttpServer server;

    public ApplicationServer(int port) throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
    }

    public void createContexts() {
        server.createContext("/", new RequestHandler());
    }

    public void start() {
        server.setExecutor(null); // Use default executor
        server.start();
        System.out.println("Server started at http://localhost:" + server.getAddress().getPort() + "/");
    }
}
