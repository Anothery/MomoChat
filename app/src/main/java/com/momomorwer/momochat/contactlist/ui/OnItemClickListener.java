package com.momomorwer.momochat.contactlist.ui;

import com.momomorwer.momochat.contactlist.entities.User;

public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}