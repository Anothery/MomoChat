package com.momomorwer.momochat.lib;

public class GREventBus implements EventBus {
    org.greenrobot.eventbus.EventBus eventBus;

    private static class SingletonHolder {
        private static final GREventBus INSTANCE = new GREventBus();
    }

    public static GREventBus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public GREventBus(){
        eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Override
    public void register(Object subscriber){
        eventBus.register(subscriber);
    }
    @Override
    public void unregister(Object subscriber){
        eventBus.unregister(subscriber);
    }
    @Override
    public void post(Object event){
        eventBus.post(event);
    }

    }

