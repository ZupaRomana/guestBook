package guestBook;

import java.util.ArrayList;
import java.util.List;

public class Message {

    private static List<Message> messages = new ArrayList<>();

    private String name;
    private String text;

    public Message(String name, String text) {
        this.name = name;
        this.text = text;

        messages.add(this);
    }

    public static List<Message> getMessages() {
        return messages;
    }
}
