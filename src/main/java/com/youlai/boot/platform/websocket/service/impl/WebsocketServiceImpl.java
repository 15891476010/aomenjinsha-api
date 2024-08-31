package com.youlai.boot.platform.websocket.service.impl;

import com.youlai.boot.platform.websocket.service.WebsocketService;
import com.youlai.boot.system.event.UserConnectionEvent;
import com.youlai.boot.system.model.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebsocketServiceImpl implements WebsocketService {

    private final SimpMessagingTemplate messagingTemplate;

    private final Set<String> onlineUsers = ConcurrentHashMap.newKeySet();

    @Override
    public void addUser(String username) {
        onlineUsers.add(username);
    }

    @Override
    public void removeUser(String username) {
        onlineUsers.remove(username);
    }

    @Override
    public Set<String> getUsers() {
        return onlineUsers;
    }

    @EventListener
    public void handleUserConnectionEvent(UserConnectionEvent event) {
        String username = event.getUsername();
        if (event.isConnected()) {
            onlineUsers.add(username);
            log.info("User connected: {}", username);
        } else {
            onlineUsers.remove(username);
            log.info("User disconnected: {}", username);
        }
        // 推送在线用户人数
        messagingTemplate.convertAndSend("/topic/onlineUserCount", onlineUsers.size());
    }

    @Scheduled(fixedRate = 5000)
    public void sendOnlineUserCount() {
        messagingTemplate.convertAndSend("/topic/onlineUserCount", onlineUsers.size());
    }

    @Override
    public void sendStringToFrontend(String sender, String message) {
        ChatMessage chatMessage = new ChatMessage(sender, message);
        onlineUsers.forEach(receiver -> {
            messagingTemplate.convertAndSendToUser(receiver, "/topic/chat", chatMessage);
        });
    }
}
