package com.example.xm1.interfaces.home;

import com.example.xm1.bean.HomeBean;
import com.example.xm1.interfaces.IBasePresenter;
import com.example.xm1.interfaces.IBaseView;

public interface IHome {
    interface RecommendView extends IBaseView {
        //首页数据
        void getHomeResult(HomeBean result);
    }

    interface RecommendPersenter extends IBasePresenter<RecommendView> {
        //请求首页数据
        void getHome();
    }

}
