package pens.lab.app.belajaractivity.modul.signup;

import pens.lab.app.belajaractivity.model.User;
import pens.lab.app.belajaractivity.callback.RequestCallback;

public class SignupPresenter implements SignupContract.Presenter{
    private final SignupContract.View view;
    private final SignupContract.Interactor interactor;

    public SignupPresenter(SignupContract.View view, SignupContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {}

    @Override
    public void performRegister(User user){
        view.startLoading();
        interactor.requestRegister(user, new RequestCallback<String>() {
            @Override
            public void requestSuccess(String data) {
                view.returnSuccess(data);
                view.endLoading();
            }

            @Override
            public void requestFailed(String errorMessage) {
                view.showError(errorMessage);
                view.endLoading();
            }
        });
    }

}
