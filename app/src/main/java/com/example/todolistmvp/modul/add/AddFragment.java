package com.example.todolistmvp.modul.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.todolistmvp.R;
import com.example.todolistmvp.base.BaseFragment;
import com.example.todolistmvp.data.model.Task;
import com.example.todolistmvp.modul.todo.ToDoActivity;
import com.example.todolistmvp.utils.Database;

import java.util.ArrayList;

public class AddFragment extends BaseFragment<AddActivity, AddContract.Presenter> implements AddContract.View {
    private EditText newTitle;
    private EditText newDescription;
    private Button btnAdd;
    private ArrayList<Task> taskList;
    private Database database;

    public AddFragment() {
        this.database = Database.getInstance();
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add, container, false);
        mPresenter = new AddPresenter(this);
        mPresenter.start();

        taskList = database.getTasks();
        newTitle = fragmentView.findViewById(R.id.newTitle);
        newDescription = fragmentView.findViewById(R.id.newDescription);
        btnAdd = fragmentView.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.performAdd();
            }
        });

        setTitle("ADD ITEM");

        return fragmentView;
    }

    @Override
    public void setPresenter(AddContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void addItem() {
        if(newTitle.getText() != null && newDescription.getText() != null)
            database.addTask(newTitle.getText().toString(), newDescription.getText().toString());

        Intent returnIntent = new Intent(activity, ToDoActivity.class);
        startActivity(returnIntent);
        activity.finish();
    }
}
