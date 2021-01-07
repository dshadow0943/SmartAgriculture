package com.example.smartagriculture.base;

import com.example.smartagriculture.presenter.IPresenter;
import com.example.smartagriculture.view.IView;

public abstract class PresenterBase<T extends IView> implements IPresenter<T> {
    public T mView;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }



//    @Override
//    public boolean isUserData() {
//        if (repositoryApi.getStudentNumber() == null || repositoryApi.getPassword() == null){
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public void getToken(TokenCallback callback) {
//        repositoryApi.login(repositoryApi.getStudentNumber() , repositoryApi.getPassword(), "Jit")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ResultEntity<Token>>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                    }
//
//                    @Override
//                    public void onNext(ResultEntity<Token> response) {
//                        if (response.getCode() == 200) {
//                            SpareData.putStringData(SpareData.TOKEN, response.getData().getToken());
//                            callback.getTokenSuccess(response.getData().getToken());
//                        } else {
//                            callback.getTokenFailed(response.getCode(), response.getMsg());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        //关闭对话框
//                        callback.getTokenFailed(0, throwable.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() { }
//                });
//    }
}
