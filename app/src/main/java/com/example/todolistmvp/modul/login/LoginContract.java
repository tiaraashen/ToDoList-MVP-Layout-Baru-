package com.example.todolistmvp.modul.login;

import com.example.todolistmvp.base.BasePresenter;
import com.example.todolistmvp.base.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
    }

    interface Presenter extends BasePresenter {
        void performLogin(String email, String password);
    }
}
