package com.momomorwer.momochat.contactlist;

import android.view.View;

import com.momomorwer.momochat.contactlist.events.ContactListEvent;
import com.momomorwer.momochat.contactlist.ui.ContactListView;
import com.momomorwer.momochat.lib.EventBus;

public class ContactListPresenterImpl implements ContactListPresenter{

    EventBus eventBus;
    ContactListView contactListView;

    public ContactListPresenterImpl(ContactListView view){
        contactListView = view;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void signOff() {

    }

    @Override
    public String getCurrentUserEmail() {
        return null;
    }

    @Override
    public void removeContact(String email) {

    }

    @Override
    public void onEventMainThread(ContactListEvent event) {

    }
}
