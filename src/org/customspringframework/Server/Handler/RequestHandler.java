package org.customspringframework.Server.Handler;

import org.customspringframework.Routing.Route;
import org.customspringframework.Server.Errors.HttpErrorCode;
import org.customspringframework.Server.Handler.impl.DefaultResponseSender;
import org.customspringframework.Server.Handler.impl.DefaultRouteResolver;
import org.customspringframework.Server.Handler.impl.PathVariableArgumentResolver;
import org.customspringframework.Server.Handler.impl.ReflectiveMethodInvoker;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class RequestHandler implements HttpHandler {

    private final RouteResolver routeResolver = new DefaultRouteResolver();
    private final ArgumentResolver argumentResolver = new PathVariableArgumentResolver();
    private final MethodInvoker methodInvoker = new ReflectiveMethodInvoker();
    private final ResponseSender responseSender = new DefaultResponseSender();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();

        Route route = routeResolver.resolve(method, path);
        if (route == null) {
            responseSender.sendError(exchange, HttpErrorCode.NOT_FOUND, "No handler for route: " + method + ":" + path);
            return;
        }

        try {
            Object[] args = argumentResolver.resolveArguments(route, method + ":" + path);
            Object result = methodInvoker.invoke(route, args);
            String response = (result != null) ? result.toString() : HttpErrorCode.NO_CONTENT.toString();
            responseSender.sendSuccess(exchange, response);
        } catch (Exception e) {
            Throwable cause = (e.getCause() != null) ? e.getCause() : e;
            responseSender.sendError(exchange, HttpErrorCode.INTERNAL_SERVER_ERROR, cause.toString());
        }
    }
}
