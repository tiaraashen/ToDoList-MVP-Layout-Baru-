package com.example.todolistmvp.modul.login;

import com.example.todolistmvp.data.model.User;
import com.example.todolistmvp.data.source.session.SessionRepository;

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View view;
    private final SessionRepository sessionRepository;

    public LoginPresenter(LoginContract.View view, SessionRepository sessionRepository) {
        this.view = view;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void start() {
        if (sessionRepository.getSessionData() != null)
            view.redirectToProfile();
    }

    @Override
    public void performLogin(final String email, final String password){
        User loggedUser = new User(email, "TOKEN123456");
        sessionRepository.setSessionData(loggedUser);

        view.redirectToProfile();
    }
}
