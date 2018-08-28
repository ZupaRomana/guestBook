package guestBook;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

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

    private void appendMessage() throws IOException {

        String formData = getFormData();
        Map inputs = parseFormData(formData);

    }

    private void sendResponse() throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private String getFormData() throws IOException {
        InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);

        return br.readLine();
    }

    private static Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String[] pairs = formData.split("&");
        for(String pair : pairs){
            String[] keyValue = pair.split("=");
            String value = new URLDecoder().decode(keyValue[1], "UTF-8");
            map.put(keyValue[0], value);
        }
        return map;
    }
}
