package com.example.todolistmvp.modul.login;

import android.os.Bundle;
import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

public class ShowLoginActivity extends BaseFragmentHolderActivity {
    ShowLoginFragment profileFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        Bundle bundle = getIntent().getExtras();
        profileFragment = new ShowLoginFragment(bundle);
        setCurrentFragment(profileFragment, false);
    }
}
