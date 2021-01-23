package pens.lab.app.belajaractivity.modul.add;
import pens.lab.app.belajaractivity.model.Task;
import pens.lab.app.belajaractivity.callback.RequestCallback;

public class AddPresenter implements AddContract.Presenter{

    private final AddContract.View view;
    private final AddContract.Interactor interactor;

    public AddPresenter(AddContract.View view, AddContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {}

    @Override
    public void performAdd(Task task){
        view.startLoading();
        interactor.requestAddTask(task, new RequestCallback<String>() {
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
