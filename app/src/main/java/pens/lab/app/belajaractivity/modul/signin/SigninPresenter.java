package pens.lab.app.belajaractivity.modul.signin;

import pens.lab.app.belajaractivity.callback.RequestCallback;

public class SigninPresenter implements SigninContract.Presenter{
    private final SigninContract.View view;
    private final SigninContract.Interactor interactor;

    public SigninPresenter(SigninContract.View view, SigninContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {}

    @Override
    public void performLogin(final String email, final String password){
        view.startLoading();
       interactor.requestLogin(email, password, new RequestCallback<String>() {
           @Override
           public void requestSuccess(String data) {
               interactor.saveToken(data);
               view.redirectToList();
               view.endLoading();
           }

           @Override
           public void requestFailed(String errorMessage) {
                view.showError(errorMessage);
                view.endLoading();
           }
       });
    }

    @Override
    public void performGoogleLogin(String email, String name) {
        view.startLoading();
        interactor.requestGoogleLogin(email, name, new RequestCallback<String>() {
            @Override
            public void requestSuccess(String data) {
                interactor.saveToken(data);
                view.redirectToList();
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
