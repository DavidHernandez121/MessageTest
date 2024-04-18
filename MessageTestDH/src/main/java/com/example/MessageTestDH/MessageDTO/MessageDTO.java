package com.example.MessageTestDH.MessageDTO;

import java.util.List;

public class MessageDTO {
    private Long id;
    private List<String> message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
