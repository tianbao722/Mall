package com.example.xm1.ui.special;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.xm1.R;
import com.example.xm1.base.BaseFragment;
import com.example.xm1.base.BasePresenter;
import com.example.xm1.interfaces.IBasePresenter;

import butterknife.BindView;

public class SpecialFragment extends BaseFragment {

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showTips(String tips) {

    }

    @Override
    public void showLoading(int visble) {

    }
}
