package com.momomorwer.momochat.contactlist;

import com.momomorwer.momochat.contactlist.events.ContactListEvent;

public interface ContactListPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
