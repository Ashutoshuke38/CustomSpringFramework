package org.customspringframework.Server.Handler;

import org.customspringframework.Server.Errors.HttpErrorCode;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public interface ResponseSender {
    void sendSuccess(HttpExchange exchange, String message) throws IOException;
    void sendError(HttpExchange exchange, HttpErrorCode error, String details) throws IOException;
}
