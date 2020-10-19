package com.example.todolistmvp.modul.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.todolistmvp.R;
import com.example.todolistmvp.base.BaseFragment;
import com.example.todolistmvp.modul.todolist.ToDoListActivity;

public class ShowLoginFragment extends BaseFragment<ShowLoginActivity, ShowLoginContract.Presenter> implements ShowLoginContract.View {
    TextView tvEmail;
    TextView tvPassword;
    Button btnToDo;
    Button btnLogout;
    Bundle bundle;

    public ShowLoginFragment(Bundle bundle) {
        this.bundle = bundle;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_show_login, container, false);
        mPresenter = new ShowLoginPresenter(this);
        mPresenter.start();

        tvEmail = fragmentView.findViewById(R.id.tv_email);
        tvPassword = fragmentView.findViewById(R.id.tv_password);

        mPresenter.getUserInfo(bundle);

        btnToDo = fragmentView.findViewById(R.id.bt_todo);
        btnToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtToDoClick();
            }
        });

        btnLogout = fragmentView.findViewById(R.id.bt_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLogoutClick();
            }
        });

        setTitle("My Profile View");

        return fragmentView;
    }

    public void setBtToDoClick(){
        mPresenter.performToDoList();
    }

    public void setBtLogoutClick(){
        mPresenter.performLogout();
    }

    @Override
    public void setPresenter(ShowLoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showUser(String email, String password) {
        tvEmail.setText(email);
        tvPassword.setText(password);
    }

    @Override
    public void redirectToToDoList() {
        Intent intent = new Intent(activity, ToDoListActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void redirectToLogin() {
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
