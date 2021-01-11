package com.example.smartagriculture.presenter;

import com.example.smartagriculture.interfaces.TokenCallback;
import com.example.smartagriculture.model.IModel;
import com.example.smartagriculture.view.IView;

public interface IPresenter<T extends IView> {

    /**
     * 依附生命view
     *
     * @param view
     */
    void attachView(T view);

    /**
     * 分离View
     */
    void detachView();

    /**
     * 判断View是否已经销毁
     *
     * @return
     */
    boolean isViewAttached();

//    /**
//     * 判断本地数据库是否拥有用户账号数据
//     * @return
//     */
//    boolean isUserData();
//
//    /**
//     * 获取Token数据
//     * @param callback
//     */
//    void getToken(TokenCallback callback);

}
