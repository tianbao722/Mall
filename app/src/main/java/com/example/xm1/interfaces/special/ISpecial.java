package com.example.xm1.interfaces.special;

import com.example.xm1.interfaces.IBasePresenter;
import com.example.xm1.interfaces.IBaseView;

public interface ISpecial {
    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter<View> {

    }
}
