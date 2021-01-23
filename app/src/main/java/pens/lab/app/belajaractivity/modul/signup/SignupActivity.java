package pens.lab.app.belajaractivity.modul.signup;

import android.view.View;

import pens.lab.app.belajaractivity.base.BaseFragmentHolderActivity;


public class SignupActivity extends BaseFragmentHolderActivity {
    SignupFragment signupFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        toolbar.setVisibility(View.GONE);
        vMenuBarShadow.setVisibility(View.GONE);
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);

        signupFragment = new SignupFragment();
        setCurrentFragment(signupFragment, false);

    }




}
