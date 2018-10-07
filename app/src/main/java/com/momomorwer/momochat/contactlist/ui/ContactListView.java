package com.momomorwer.momochat.contactlist.ui;

import com.momomorwer.momochat.contactlist.entities.User;

public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
