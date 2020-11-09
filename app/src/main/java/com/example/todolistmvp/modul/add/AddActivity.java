package com.example.todolistmvp.modul.add;

import android.content.Intent;
import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

import java.util.ArrayList;

public class AddActivity extends BaseFragmentHolderActivity {
    AddFragment addFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        Intent intent = getIntent();
        ArrayList<String> toDoList = intent.getStringArrayListExtra("todo");

        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        addFragment = new AddFragment(toDoList);
        setCurrentFragment(addFragment, false);
    }
}
