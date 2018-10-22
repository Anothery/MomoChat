package com.momomorwer.momochat.chat.events;

import com.momomorwer.momochat.chat.entities.ChatMessage;

public class ChatEvent {
    ChatMessage msg;

    public ChatEvent(ChatMessage msg) {
        this.msg = msg;
    }

    public ChatMessage getMessage() {
        return msg;
    }
}
