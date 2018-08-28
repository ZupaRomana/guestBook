package guestBook;

import java.util.ArrayList;
import java.util.List;

public class Message {

    private static List<Message> messages = new ArrayList<>();

    private String author;
    private String text;

    public Message(String author, String text) {
        this.author = author;
        this.text = text;

        messages.add(this);
    }

    public static List<Message> getMessages() {
        return messages;
    }
}
