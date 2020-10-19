package com.example.todolistmvp.modul.login;

import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

public class LoginActivity extends BaseFragmentHolderActivity {
    LoginFragment loginFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        loginFragment = new LoginFragment();
        setCurrentFragment(loginFragment, false);
    }
}
