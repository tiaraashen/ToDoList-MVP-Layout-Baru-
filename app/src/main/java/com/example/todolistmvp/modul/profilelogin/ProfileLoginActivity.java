package com.example.todolistmvp.modul.profilelogin;

import android.os.Bundle;
import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

public class ProfileLoginActivity extends BaseFragmentHolderActivity {
    ProfileLoginFragment profileLoginFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        Bundle bundle = getIntent().getExtras();
        profileLoginFragment = new ProfileLoginFragment(bundle);
        setCurrentFragment(profileLoginFragment, false);
    }
}
