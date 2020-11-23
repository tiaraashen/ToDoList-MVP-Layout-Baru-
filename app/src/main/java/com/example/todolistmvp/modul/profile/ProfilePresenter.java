package com.example.todolistmvp.modul.profile;

import android.os.Bundle;

public class ProfilePresenter implements ProfileContract.Presenter {
    private final ProfileContract.View view;

    public ProfilePresenter(ProfileContract.View view) {
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
