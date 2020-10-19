package com.example.todolistmvp.modul.add;

import com.example.todolistmvp.base.BasePresenter;
import com.example.todolistmvp.base.BaseView;

public interface AddContract {
    interface View extends BaseView<AddContract.Presenter> {
        void addItem();
    }

    interface Presenter extends BasePresenter {
        void performAdd();
    }
}
