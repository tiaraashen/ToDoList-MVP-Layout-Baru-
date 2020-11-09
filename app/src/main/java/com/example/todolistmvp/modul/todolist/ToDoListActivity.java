package com.example.todolistmvp.modul.todolist;

import android.content.Intent;
import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

import java.util.ArrayList;

public class ToDoListActivity extends BaseFragmentHolderActivity {
    ToDoListFragment toDoListFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        Intent dataIntent = getIntent();
        ArrayList<String> returnedList = dataIntent.getStringArrayListExtra("returnData");
        toDoListFragment = new ToDoListFragment(returnedList);
        setCurrentFragment(toDoListFragment, true);
    }
}
