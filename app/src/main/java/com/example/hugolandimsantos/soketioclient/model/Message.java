package com.example.hugolandimsantos.soketioclient.model;

/**
 * Created by hugo.landim.santos on 18/11/2015.
 */
public class Message {

    private String message;
    private Type type;

    public Message(String message, Type type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        SEND, RECEIVED
    }
}
