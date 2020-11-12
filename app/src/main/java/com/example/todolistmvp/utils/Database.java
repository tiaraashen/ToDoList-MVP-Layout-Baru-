package com.example.todolistmvp.utils;

import com.example.todolistmvp.data.model.Task;

import java.util.ArrayList;

public class Database {
    private ArrayList<Task> tasks;
    private static Database instance;
    private static int id = 1;

    public Database(){
        tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void editTask(int id, String title, String description){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id) {
                tasks.get(i).setTitle(title);
                tasks.get(i).setDescription(description);
                break;
            }
        }
    }

    public void addTask(String title, String desc){
        Task newTask = new Task(id, title, desc);
        tasks.add(newTask);
        id++;
    }

    public void deleteTask(int id){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id) {
                tasks.remove(i);
                break;
            }
        }
    }

    public void deleteAll(){
        tasks.clear();
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
}
