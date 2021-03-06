package com.example.xm1.adapter.homeadapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xm1.R;
import com.example.xm1.base.BaseAdapter;
import com.example.xm1.bean.HomeBean;

import java.util.List;

import butterknife.BindView;

public class HomeCaiNiRlvAdapter extends BaseAdapter {


    public HomeCaiNiRlvAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.item6_home_rlv;
    }

    @Override
    protected void bindData(BaseViewHolder viewHolder, Object o) {
        ImageView img = (ImageView) viewHolder.getViewById(R.id.iv_img_item6_home);
        TextView name = (TextView) viewHolder.getViewById(R.id.tv_item6_name);
        TextView jieshao = (TextView) viewHolder.getViewById(R.id.tv_item6_jieshao);
        TextView jiage = (TextView) viewHolder.getViewById(R.id.tv_miao_item6_rlv);
        HomeBean.DataBean.NewProductListBean bean = (HomeBean.DataBean.NewProductListBean) o;
        name.setText(bean.getName());
        Glide.with(context).load(bean.getPic()).into(img);
        jieshao.setText(bean.getSubTitle());
        jiage.setText("¥"+bean.getOriginalPrice());
    }
}
