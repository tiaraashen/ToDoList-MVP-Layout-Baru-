package pens.lab.app.belajaractivity.modul.add;

import android.view.View;

import pens.lab.app.belajaractivity.base.BaseFragmentHolderActivity;


public class AddActivity extends BaseFragmentHolderActivity {
    AddFragment addFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        //btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);

        addFragment = new AddFragment();
        setCurrentFragment(addFragment, true);

    }

}
