package com.momomorwer.momochat.chat.ui;

import com.momomorwer.momochat.chat.entities.ChatMessage;

public interface ChatView {
    void sendMessage();
    void onMessageReceived(ChatMessage msg);
}
