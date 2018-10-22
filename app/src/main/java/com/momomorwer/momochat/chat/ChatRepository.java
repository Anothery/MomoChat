package com.momomorwer.momochat.chat;

public interface ChatRepository {
    void sendMessage(String msg);
    void setReceiver(String receiver);

    void destroyChatListener();
    void subscribeForChatUpdates();
    void unSubscribeForChatUpdates();

    void changeUserConnectionStatus(boolean online);
}
