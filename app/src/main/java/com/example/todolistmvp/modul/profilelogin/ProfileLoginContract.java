package com.example.todolistmvp.modul.profilelogin;

import android.os.Bundle;

import com.example.todolistmvp.base.BasePresenter;
import com.example.todolistmvp.base.BaseView;

public interface ProfileLoginContract {
    interface View extends BaseView<Presenter> {
        void showUser(String email, String password);
        void redirectToToDoList();
    }

    interface Presenter extends BasePresenter {
        void getUserInfo(Bundle bundle);
        void performToDoList();
    }
}
