package application.models;

import lombok.*;

@Setter
@Getter

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }
}