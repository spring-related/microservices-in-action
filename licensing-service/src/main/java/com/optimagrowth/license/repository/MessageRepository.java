package com.optimagrowth.license.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageRepository {
    private List<String> list = new ArrayList<>();

    public void addMessage(String message) {
        list.add(message);
    }

    public String getAllMessages() {
        return list.toString();
    }
}
