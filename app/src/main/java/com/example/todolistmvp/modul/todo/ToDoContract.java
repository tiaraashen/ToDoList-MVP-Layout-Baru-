package com.example.todolistmvp.modul.todo;

import com.example.todolistmvp.base.BasePresenter;
import com.example.todolistmvp.base.BaseView;
import com.example.todolistmvp.data.model.Task;

public interface ToDoContract {
    interface View extends BaseView<ToDoContract.Presenter> {
        void redirectToAdd();
        void emptyList();
        void showEditBox(final Task uneditedItem);
        void showDeleteDialog(final int position);
        void redirectToLogin();
    }

    interface Presenter extends BasePresenter {
        void addItem();
        void clearList();
        void editList(final Task uneditedItem);
        void deleteItem(final int position);
        void performLogout();
    }
}
