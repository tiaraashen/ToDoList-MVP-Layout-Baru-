package com.example.todolistmvp.modul.todolist;

import com.example.todolistmvp.base.BasePresenter;
import com.example.todolistmvp.base.BaseView;

public interface ToDoListContract {
    interface View extends BaseView<ToDoListContract.Presenter> {
        void redirectToAdd();
        void emptyList();
        void showEditBox(String uneditedItem, final int index);
        void showDeleteDialog(final int position);
    }

    interface Presenter extends BasePresenter {
        void addItem();
        void clearList();
        void editList(String uneditedItem, final int index);
        void deleteItem(final int position);
    }
}
