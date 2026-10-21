package com.example.staynest.chat.reactive.infrastructure.session;

import com.example.staynest.chat.reactive.domain.ChatMessage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class GroupConnection {

    private final Sinks.Many<ChatMessage> groupSink =
            Sinks.many().multicast().onBackpressureBuffer();

    public Flux<ChatMessage> messages(){
        return groupSink.asFlux();
    }

    public boolean send(ChatMessage message){
        return groupSink.tryEmitNext(message).isSuccess();
    }

    public void complete(){
        groupSink.tryEmitComplete();
    }
}
