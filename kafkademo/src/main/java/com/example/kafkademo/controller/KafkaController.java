package com.example.kafkademo.controller;

import com.example.kafkademo.service.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final MessageProducer messageProducer;

    public KafkaController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message) {
        messageProducer.sendMessage("test-topic", message);
        return ResponseEntity.ok("Message sent to Kafka");
    }
}
