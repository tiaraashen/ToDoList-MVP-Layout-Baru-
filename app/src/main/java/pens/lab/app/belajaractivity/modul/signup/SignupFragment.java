package pens.lab.app.belajaractivity.modul.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.model.User;
import pens.lab.app.belajaractivity.modul.signin.SigninActivity;
import pens.lab.app.belajaractivity.utils.UtilProvider;

public class SignupFragment extends BaseFragment<SignupActivity, SignupContract.Presenter> implements SignupContract.View {

    EditText etName;
    EditText etEmail;
    EditText etPassword;
    Button btnRegister;
    Button btnBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_signup, container, false);
        initView();
        setOnClickListener();
        return fragmentView;
    }

    private void setOnClickListener() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtRegisterClick();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
                startActivity(new Intent(activity, SigninActivity.class));
            }
        });
    }

    private void initView(){
        mPresenter = new SignupPresenter(this, new SignupInteractor(UtilProvider.getSharedPreferencesUtil()));
        mPresenter.start();
        etName = fragmentView.findViewById(R.id.et_name);
        etEmail = fragmentView.findViewById(R.id.et_email);
        etPassword = fragmentView.findViewById(R.id.et_password);
        btnRegister = fragmentView.findViewById(R.id.bt_login);
        btnBack = fragmentView.findViewById(R.id.bt_back);
    }

    @Override
    public void startLoading() {
        fragmentView.findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
    }

    @Override
    public void endLoading() {
        fragmentView.findViewById(R.id.progress_bar).setVisibility(View.GONE);
    }

    public void setBtRegisterClick(){
        User user;
        if(etName.getText() != null && etPassword.getText() != null && etEmail.getText() != null){
            user = new User(etName.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString());
            mPresenter.performRegister(user);
        }else
            Toast.makeText(activity, "All fields must be filled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(SignupContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToLogin() {
        activity.finish();
        startActivity(new Intent(activity, SigninActivity.class));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void returnSuccess(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
        redirectToLogin();
    }
}
