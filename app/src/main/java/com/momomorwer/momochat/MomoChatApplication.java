package com.momomorwer.momochat;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import com.momomorwer.momochat.lib.GlideImageLoader;
import com.momomorwer.momochat.lib.ImageLoader;

public class MomoChatApplication extends Application {
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
        setupImageLoader();
    }

    private void setupImageLoader() {
        imageLoader = new GlideImageLoader(this);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    private void setupFirebase(){
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
