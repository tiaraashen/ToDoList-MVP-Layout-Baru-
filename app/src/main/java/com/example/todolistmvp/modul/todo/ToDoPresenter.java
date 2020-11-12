package com.example.todolistmvp.modul.todo;

import com.example.todolistmvp.data.model.Task;

public class ToDoPresenter implements ToDoContract.Presenter {
    private final ToDoContract.View view;

    public ToDoPresenter(ToDoContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void addItem() {
        view.redirectToAdd();
    }

    @Override
    public void clearList() {
        view.emptyList();
    }

    @Override
    public void editList(final Task uneditedItem) {
        view.showEditBox(uneditedItem);
    }

    @Override
    public void deleteItem(final int position) {
        view.showDeleteDialog(position);
    }

    @Override
    public void performLogout(){
        view.redirectToLogin();
    }
}
