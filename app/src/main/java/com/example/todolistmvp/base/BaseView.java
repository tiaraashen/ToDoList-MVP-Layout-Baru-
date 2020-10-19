package com.example.todolistmvp.base;

public interface BaseView<T> {
    void setPresenter(T presenter);
}