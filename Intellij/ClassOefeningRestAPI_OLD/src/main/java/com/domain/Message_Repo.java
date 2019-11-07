package com.domain;

import org.springframework.stereotype.Component;

@Component
public class Message_Repo {
    private Integer id;
    private String message;


    public Message_Repo() {
        this.message = "Hello Mars";
        this.id = 4;
    }

    public Message_Repo(String message, Integer id) {
        this.message = message;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Message_Repo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message_Repo setMessage(String message) {
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
