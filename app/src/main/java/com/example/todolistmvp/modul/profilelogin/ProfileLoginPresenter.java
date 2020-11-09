package com.example.todolistmvp.modul.profilelogin;

import android.os.Bundle;

public class ProfileLoginPresenter implements ProfileLoginContract.Presenter {
    private final ProfileLoginContract.View view;

    public ProfileLoginPresenter(ProfileLoginContract.View view) {
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
}
