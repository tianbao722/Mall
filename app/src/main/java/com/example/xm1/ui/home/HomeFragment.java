package com.example.xm1.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xm1.R;
import com.example.xm1.adapter.HomeMiaoShaAdapter;
import com.example.xm1.adapter.HomeNewAdapter;
import com.example.xm1.adapter.HomePinPaiAdapter;
import com.example.xm1.base.BaseFragment;
import com.example.xm1.bean.HomeBean;
import com.example.xm1.interfaces.home.IHome;
import com.example.xm1.presenter.home.HomePresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<IHome.RecommendPersenter> implements IHome.RecommendView {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.ll_huati)
    LinearLayout llHuati;
    @BindView(R.id.ll_youxuan)
    LinearLayout llYouxuan;
    @BindView(R.id.ll_tehui)
    LinearLayout llTehui;
    @BindView(R.id.ll_qiandao)
    LinearLayout llQiandao;
    @BindView(R.id.ll_daohang)
    LinearLayout llDaohang;
    @BindView(R.id.v_home)
    View vHome;
    @BindView(R.id.vf)
    ViewFlipper vf;
    @BindView(R.id.v_rlv)
    View vRlv;
    @BindView(R.id.rlv_home)
    RecyclerView rlvHome;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans;
    private DelegateAdapter delegateAdapter;
    private ArrayList<HomeBean.DataBean.HotProductListBean> hotProductListBeans;
    private ArrayList<HomeBean.DataBean.NewProductListBean> newProductListBeans;

    @Override
    protected IHome.RecommendPersenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        setRlv();
        setVf();
    }

    private void setRlv() {
        brandListBeans = new ArrayList<>();
        hotProductListBeans = new ArrayList<>();
        newProductListBeans = new ArrayList<>();
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        rlvHome.setRecycledViewPool(recycledViewPool);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        delegateAdapter = new DelegateAdapter(layoutManager, true);
        rlvHome.setLayoutManager(layoutManager);
        rlvHome.setAdapter(delegateAdapter);
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper(1);
        delegateAdapter.addAdapter(new HomePinPaiAdapter(getActivity(), linearLayoutHelper, brandListBeans));
        delegateAdapter.addAdapter(new HomeMiaoShaAdapter(getActivity(), linearLayoutHelper, hotProductListBeans));
        delegateAdapter.addAdapter(new HomeNewAdapter(getActivity(), linearLayoutHelper, newProductListBeans));
    }

    private void setVf() {
        vf.setFlipInterval(2000);
        vf.startFlipping();
        vf.setAutoStart(true);
        vf.setInAnimation(getActivity(), R.anim.anim_in);
        vf.setOutAnimation(getActivity(), R.anim.anim_out);
    }

    @Override
    protected void initData() {
        mPresenter.getHome();
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

    @Override
    public void getHomeResult(HomeBean result) {
        if (result.getCode() == 200) {
            List<HomeBean.DataBean.BrandListBean> brandList = result.getData().getBrandList();
            List<HomeBean.DataBean.HotProductListBean> hotProductList = result.getData().getHotProductList();
            List<HomeBean.DataBean.NewProductListBean> newProductList = result.getData().getNewProductList();
            brandListBeans.addAll(brandList);
            hotProductListBeans.addAll(hotProductList);
            newProductListBeans.addAll(newProductList);
            delegateAdapter.notifyDataSetChanged();
            ArrayList<String> images = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            List<HomeBean.DataBean.AdvertiseListBean> advertiseList = result.getData().getAdvertiseList();
            for (int i = 0; i < advertiseList.size(); i++) {
                String pic = advertiseList.get(i).getPic();
                String name = advertiseList.get(i).getName();
                images.add(pic);
                titles.add(name);
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.vf3, null);
                TextView title = inflate.findViewById(R.id.tv_title_guangao);
                title.setText(advertiseList.get(i).getName());
                vf.addView(inflate);
            }
            banner
                    .setBannerTitles(titles)
                    .setImages(images)
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context).load(path).into(imageView);
                        }
                    })
                    .start();
        }
    }
}