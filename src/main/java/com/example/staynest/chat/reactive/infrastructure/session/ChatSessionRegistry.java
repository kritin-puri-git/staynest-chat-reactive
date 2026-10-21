package com.example.staynest.chat.reactive.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatSessionRegistry {

    private static final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    public void register(String id, WebSocketSession session){
        sessions.put(id, session);
    }


    public void unregister(String id, WebSocketSession session){
        sessions.remove(id, session);
    }


    public WebSocketSession get(String id){
        return sessions.get(id);
    }
}
