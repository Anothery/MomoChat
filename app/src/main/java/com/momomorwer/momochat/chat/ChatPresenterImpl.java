package com.momomorwer.momochat.chat;

import com.momomorwer.momochat.chat.entities.ChatMessage;
import com.momomorwer.momochat.chat.events.ChatEvent;
import com.momomorwer.momochat.chat.ui.ChatView;
import com.momomorwer.momochat.contactlist.entities.User;
import com.momomorwer.momochat.contactlist.events.ContactListEvent;
import com.momomorwer.momochat.lib.EventBus;
import com.momomorwer.momochat.lib.GREventBus;

import org.greenrobot.eventbus.Subscribe;

public class ChatPresenterImpl implements ChatPresenter{
    EventBus eventBus;
    ChatView chatView;
    ChatInteractor chatInteractor;
    ChatSessionInteractor chatSessionInteractor;

    public ChatPresenterImpl(ChatView chatView){
        this.chatView = chatView;
        this.eventBus = GREventBus.getInstance();

        this.chatInteractor = new ChatInteractorImpl();
        this.chatSessionInteractor = new ChatSessionInteractorImpl();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onResume() {
        chatInteractor.subscribeForChatUpdates();
        chatSessionInteractor.changeConnectionStatus(User.ONLINE);
    }

    @Override
    public void onPause() {
        chatInteractor.unSubscribeForChatUpdates();
        chatSessionInteractor.changeConnectionStatus(User.OFFLINE);
    }

    @Override
    public void onDestroy() {
        chatSessionInteractor.changeConnectionStatus(User.OFFLINE);
        eventBus.unregister(this);
        chatInteractor.destroyChatListener();
        chatView = null;
    }

    @Override
    public void setChatRecipient(String recipient) {
        this.chatInteractor.setRecipient(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatInteractor.sendMessage(msg);
    }

    @Override
    @Subscribe
    public void onEventMainThread(ChatEvent event) {
        if (chatView != null) {
            ChatMessage msg = event.getMessage();
            chatView.onMessageReceived(msg);
        }
    }

}
