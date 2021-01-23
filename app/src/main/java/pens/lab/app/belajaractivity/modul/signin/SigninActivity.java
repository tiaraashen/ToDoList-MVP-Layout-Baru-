package pens.lab.app.belajaractivity.modul.signin;

import android.view.View;

import pens.lab.app.belajaractivity.base.BaseFragmentHolderActivity;


public class SigninActivity extends BaseFragmentHolderActivity {
    SigninFragment signinFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        toolbar.setVisibility(View.GONE);
        vMenuBarShadow.setVisibility(View.GONE);
        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);

        signinFragment = new SigninFragment();
        setCurrentFragment(signinFragment, false);

    }
}
