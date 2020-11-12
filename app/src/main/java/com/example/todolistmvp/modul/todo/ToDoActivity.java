package com.example.todolistmvp.modul.todo;

import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

public class ToDoActivity extends BaseFragmentHolderActivity {
    protected ToDoFragment toDoFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        toDoFragment = new ToDoFragment();
        setCurrentFragment(toDoFragment, true);
    }
}
