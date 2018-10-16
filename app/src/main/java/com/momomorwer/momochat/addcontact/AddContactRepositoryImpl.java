package com.momomorwer.momochat.addcontact;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.momomorwer.momochat.addcontact.events.AddContactEvent;
import com.momomorwer.momochat.contactlist.entities.User;
import com.momomorwer.momochat.lib.EventBus;
import com.momomorwer.momochat.lib.GREventBus;
import com.momomorwer.momochat.utils.FirebaseHelper;

public class AddContactRepositoryImpl implements AddContactRepository {

    @Override
    public void addContact(final String email) {
        final String key = email.replace(".","_");
        FirebaseHelper helper = FirebaseHelper.getInstance();
        final DatabaseReference userReference = helper.getUserReference(email);
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                AddContactEvent event = new AddContactEvent();
                if (user != null) {
                    boolean online = user.isOnline();
                    FirebaseHelper helper = FirebaseHelper.getInstance();

                    DatabaseReference userContactsReference = helper.getMyContactsReference();
                    userContactsReference.child(key).setValue(online);

                    String currentUserEmailKey = helper.getAuthUserEmail();
                    currentUserEmailKey = currentUserEmailKey.replace(".","_");
                    DatabaseReference reverseUserContactsReference = helper.getContactsReference(email);
                    reverseUserContactsReference.child(currentUserEmailKey).setValue(true);
                } else {
                    event.setError(true);
                }
                EventBus eventBus = GREventBus.getInstance();
                eventBus.post(event);
            }
            @Override
            public void onCancelled(DatabaseError firebaseError) {}
        });
    }
}
