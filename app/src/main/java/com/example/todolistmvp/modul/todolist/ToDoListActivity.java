package com.example.todolistmvp.modul.todolist;

import android.content.Intent;
import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

import java.util.ArrayList;

public class ToDoListActivity extends BaseFragmentHolderActivity {
    ToDoListFragment toDoFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        Intent dataIntent = getIntent();
        ArrayList<String> returnedList = dataIntent.getStringArrayListExtra("returnData");
        toDoFragment = new ToDoListFragment(returnedList);
        setCurrentFragment(toDoFragment, true);
    }
}
