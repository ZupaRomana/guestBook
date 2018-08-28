package guestBook;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        HttpServer httpServer = null;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        httpServer.createContext("/index", new GuestBook());
        httpServer.createContext("/static", new Static());

        httpServer.setExecutor(null);

        httpServer.start();
    }
}
