package com.example.xm1.interfaces.classify;


import com.example.xm1.interfaces.IBasePresenter;
import com.example.xm1.interfaces.IBaseView;

public interface IClassify {
    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter<View> {

    }
}
