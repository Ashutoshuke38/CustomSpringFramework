package org.customspringframework.Server.Handler.impl;

import org.customspringframework.Server.Errors.HttpErrorCode;
import org.customspringframework.Server.Handler.ResponseSender;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class DefaultResponseSender implements ResponseSender {

    @Override
    public void sendSuccess(HttpExchange exchange, String message) throws IOException {
        sendResponse(exchange, HttpErrorCode.OK.getCode(), message);
    }

    @Override
    public void sendError(HttpExchange exchange, HttpErrorCode error, String details) throws IOException {
        sendResponse(exchange, error.getCode(), error.getDefaultMessage() + " - " + details);
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String message) throws IOException {
        byte[] responseBytes = message.getBytes();
        exchange.sendResponseHeaders(statusCode, responseBytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseBytes);
        }
    }
}
