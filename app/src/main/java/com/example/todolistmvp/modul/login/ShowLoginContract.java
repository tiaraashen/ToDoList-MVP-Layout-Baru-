package com.example.todolistmvp.modul.login;

import android.os.Bundle;

import com.example.todolistmvp.base.BasePresenter;
import com.example.todolistmvp.base.BaseView;

public interface ShowLoginContract {
    interface View extends BaseView<Presenter> {
        void showUser(String email, String password);
        void redirectToToDoList();
        void redirectToLogin();
    }

    interface Presenter extends BasePresenter {
        void getUserInfo(Bundle bundle);
        void performToDoList();
        void performLogout();
    }
}
