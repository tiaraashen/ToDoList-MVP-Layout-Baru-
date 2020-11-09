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
import com.example.todolistmvp.modul.todolist.ToDoListActivity;

import java.util.ArrayList;

public class AddFragment extends BaseFragment<AddActivity, AddContract.Presenter> implements AddContract.View {
    EditText newData;
    Button btnAdd;
    ArrayList<String> toDoList;

    public AddFragment(ArrayList<String> toDoList) {
        this.toDoList = toDoList;
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add, container, false);
        mPresenter = new AddPresenter(this);
        mPresenter.start();

        btnAdd = fragmentView.findViewById(R.id.btnAdd);
        newData = fragmentView.findViewById(R.id.newData);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.performAdd();
            }
        });

        setTitle("Add To Do List");

        return fragmentView;
    }

    @Override
    public void setPresenter(AddContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void addItem() {
        if(newData.getText() != null)
            toDoList.add(newData.getText().toString());

        Intent returnIntent = new Intent(activity, ToDoListActivity.class);
        returnIntent.putStringArrayListExtra("returnData", toDoList);
        startActivity(returnIntent);
        activity.finish();
    }
}
