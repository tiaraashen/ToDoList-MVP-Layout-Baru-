package com.example.todolistmvp.modul.profile;

import android.os.Bundle;

import com.example.todolistmvp.base.BasePresenter;
import com.example.todolistmvp.base.BaseView;

public interface ProfileContract {
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
