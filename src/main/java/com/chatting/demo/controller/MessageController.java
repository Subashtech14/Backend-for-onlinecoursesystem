package com.chatting.demo.controller;

import com.chatting.demo.model.Message;
import com.chatting.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now());
        Message savedMessage = messageRepository.save(message);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping
    public ResponseEntity<?> getMessages(@RequestParam Long senderId, @RequestParam Long receiverId) {
        List<Message> messages = messageRepository.findBySenderAndReceiverOrderByTimestampAsc(senderId, receiverId);
        return ResponseEntity.ok(messages);
    }
}

