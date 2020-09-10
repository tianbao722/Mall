package com.example.xm1.presenter.home;

import com.example.xm1.base.BasePresenter;
import com.example.xm1.bean.HomeBean;
import com.example.xm1.common.CommonSubScriBer;
import com.example.xm1.interfaces.home.IHome;
import com.example.xm1.model.HttpManager;
import com.example.xm1.utiles.RxUtils;

public class HomePresenter extends BasePresenter<IHome.RecommendView> implements IHome.RecommendPersenter {
    @Override
    public void getHome() {
        addSubscribe(HttpManager
                .getInstance()
                .getHomeApi()
                .getHome()
                .compose(RxUtils.<HomeBean>rxScheduler())
                .subscribeWith(new CommonSubScriBer<HomeBean>(mView) {
                    @Override
                    public void onNext(HomeBean homeBean) {
                        mView.getHomeResult(homeBean);
                    }
                }));
    }
}