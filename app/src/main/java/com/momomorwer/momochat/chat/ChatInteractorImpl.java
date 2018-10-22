package com.momomorwer.momochat.chat;

public class ChatInteractorImpl implements ChatInteractor {
    ChatRepository chatRepository;

    public ChatInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void subscribeForChatUpdates() {
        chatRepository.subscribeForChatUpdates();
    }

    @Override
    public void unSubscribeForChatUpdates() {
        chatRepository.unSubscribeForChatUpdates();
    }

    @Override
    public void destroyChatListener() {
        chatRepository.destroyChatListener();
    }

    @Override
    public void setRecipient(String recipient) {
        chatRepository.setReceiver(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatRepository.sendMessage(msg);
    }
}
