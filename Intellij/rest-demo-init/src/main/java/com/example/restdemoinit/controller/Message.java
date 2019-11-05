package com.example.restdemoinit.controller;

import org.springframework.stereotype.Component;

@Component
public class Message {
    private Integer id;
    private String message;


    public Message() {
        this.message = "Hello Mars";
        this.id = 4;
    }

    public Message(String message, Integer id) {
        this.message = message;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
