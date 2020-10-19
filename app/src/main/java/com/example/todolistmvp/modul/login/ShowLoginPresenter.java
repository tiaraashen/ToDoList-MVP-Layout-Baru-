package com.example.todolistmvp.modul.login;

import android.os.Bundle;

public class ShowLoginPresenter implements ShowLoginContract.Presenter {
    private final ShowLoginContract.View view;

    public ShowLoginPresenter(ShowLoginContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void getUserInfo(Bundle bundle) {
        String email = bundle.getString("email");
        String password = bundle.getString("password");
        view.showUser(email, password);
    }

    @Override
    public void performToDoList() {
        view.redirectToToDoList();
    }

    @Override
    public void performLogout(){
        view.redirectToLogin();
    }
}
