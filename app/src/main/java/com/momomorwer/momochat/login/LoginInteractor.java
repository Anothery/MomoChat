package com.momomorwer.momochat.login;

public interface LoginInteractor {
    void checkAlreadyAuthentificated();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
