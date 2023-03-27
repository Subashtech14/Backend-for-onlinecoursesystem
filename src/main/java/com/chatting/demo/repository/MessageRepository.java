package com.chatting.demo.repository;

import com.chatting.demo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderAndReceiverOrderByTimestampAsc(Long senderId, Long receiverId);
}
