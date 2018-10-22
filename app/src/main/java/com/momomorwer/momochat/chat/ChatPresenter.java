package com.momomorwer.momochat.chat;

import com.momomorwer.momochat.chat.events.ChatEvent;
import com.momomorwer.momochat.contactlist.events.ContactListEvent;

public interface ChatPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);

    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);
}
