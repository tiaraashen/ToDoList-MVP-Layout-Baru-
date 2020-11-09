package com.example.todolistmvp.modul.todolist;


public class ToDoListPresenter implements ToDoListContract.Presenter {
    private final ToDoListContract.View view;

    public ToDoListPresenter(ToDoListContract.View view) {
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
    public void editList(String uneditedItem, int index) {
        view.showEditBox(uneditedItem, index);
    }

    @Override
    public void deleteItem(int position) {
        view.showDeleteDialog(position);
    }

    @Override
    public void performLogout(){
        view.redirectToLogin();
    }
}
