package guestBook;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class GuestBook implements HttpHandler {

    private String response;
    private HttpExchange httpExchange;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        this.response = "";
        this.httpExchange = httpExchange;

        if (isMethodPost()) {
            appendMessage();
        }

        prepareResponse();
        sendResponse();
    }

    private boolean isMethodPost() {
        return this.httpExchange.getRequestMethod().equals("POST");
    }
}
