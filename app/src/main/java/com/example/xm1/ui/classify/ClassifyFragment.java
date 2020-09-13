package com.example.xm1.ui.classify;

import androidx.fragment.app.Fragment;

import com.example.xm1.R;
import com.example.xm1.adapter.ClassifyVpTabAdapter;
import com.example.xm1.base.BaseFragment;
import com.example.xm1.interfaces.IBasePresenter;
import com.example.xm1.ui.classify.fragment.BabyFragment;
import com.example.xm1.ui.classify.fragment.ClothingFragment;
import com.example.xm1.ui.classify.fragment.DietFragment;
import com.example.xm1.ui.classify.fragment.FittingFragment;
import com.example.xm1.ui.classify.fragment.KitchenFragment;
import com.example.xm1.ui.classify.fragment.LivintFragment;
import com.example.xm1.ui.classify.fragment.SundryFragment;
import com.example.xm1.ui.classify.fragment.WashFragment;
import com.example.xm1.zidingyiView.DefaultTransformer;
import com.example.xm1.zidingyiView.VerticalViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class ClassifyFragment extends BaseFragment {
    String[] tab = {"服装", "餐厨", "配件", "居家", "洗护", "婴童", "杂货", "饮食"};
    @BindView(R.id.tablayout)
    VerticalTabLayout tablayout;
    @BindView(R.id.vp_tab)
    VerticalViewPager vpTab;
    private ArrayList<Fragment> fragments;

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_class;
    }

    @Override
    protected void initView() {
        fragments = new ArrayList<>();
        fragments.add(new ClothingFragment());//服装
        fragments.add(new KitchenFragment());//餐厨
        fragments.add(new FittingFragment());//配件
        fragments.add(new LivintFragment());////居家
        fragments.add(new WashFragment());//洗护
        fragments.add(new BabyFragment());//婴童
        fragments.add(new SundryFragment());//杂货
        fragments.add(new DietFragment());//饮食
        ClassifyVpTabAdapter classifyVpTabAdapter = new ClassifyVpTabAdapter(getFragmentManager(), tab, fragments);
        vpTab.setAdapter(classifyVpTabAdapter);
        vpTab.setPageTransformer(true, new DefaultTransformer());
        tablayout.setupWithViewPager(vpTab);
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
