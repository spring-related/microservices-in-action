package com.optimagrowth.license.controller;

import com.optimagrowth.license.repository.MessageRepository;
import com.optimagrowth.license.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRestController {
    private final MessageProducer producer;
    private final MessageRepository messageRepository;

    public KafkaRestController(MessageProducer producer, MessageRepository messageRepository) {
        this.producer = producer;
        this.messageRepository = messageRepository;
    }

    @GetMapping("/send")
    public String sendMsg(@RequestParam("msg") String message) {
        producer.sendMessage(message);
        return message +" sent successfully!";
    }

    @GetMapping("/getAll")
    public String getAllMessages() {
        return messageRepository.getAllMessages();
    }
}
