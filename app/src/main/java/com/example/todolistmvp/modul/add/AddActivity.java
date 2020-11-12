package com.example.todolistmvp.modul.add;

import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

public class AddActivity extends BaseFragmentHolderActivity {
    protected AddFragment addFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        addFragment = new AddFragment();
        setCurrentFragment(addFragment, false);
    }
}
