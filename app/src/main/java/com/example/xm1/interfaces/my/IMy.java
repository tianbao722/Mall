package com.example.xm1.interfaces.my;

import com.example.xm1.interfaces.IBasePresenter;
import com.example.xm1.interfaces.IBaseView;

public interface IMy {
    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter<View> {

    }
}
