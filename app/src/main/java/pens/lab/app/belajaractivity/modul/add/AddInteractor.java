package pens.lab.app.belajaractivity.modul.add;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import pens.lab.app.belajaractivity.constant.ApiConstant;
import pens.lab.app.belajaractivity.model.Task;
import pens.lab.app.belajaractivity.api_response.ErrorResponse;
import pens.lab.app.belajaractivity.api_response.ResponseMessage;
import pens.lab.app.belajaractivity.callback.RequestCallback;
import pens.lab.app.belajaractivity.utils.SharedPreferencesUtil;

public class AddInteractor implements AddContract.Interactor{
    private SharedPreferencesUtil sharedPreferencesUtil;

    public AddInteractor(SharedPreferencesUtil sharedPreferencesUtil) {
        this.sharedPreferencesUtil = sharedPreferencesUtil;
    }

    @Override
    public void requestAddTask(Task task, final RequestCallback<String> callback) {
        AndroidNetworking.post(ApiConstant.BASE_URL + "task")
                .addHeaders("Authorization", "Bearer " + sharedPreferencesUtil.getToken())
                .addBodyParameter("title", task.getTitle())
                .addBodyParameter("description", task.getDescription())
                .build()
                .getAsObject(ResponseMessage.class, new ParsedRequestListener<ResponseMessage>() {
                    @Override
                    public void onResponse(ResponseMessage response) {
                        callback.requestSuccess(response.message);
                    }
                    @Override
                    public void onError(ANError error) {
                        callback.requestFailed(ErrorResponse.requestFailed);
                    }
                });
    }
}
