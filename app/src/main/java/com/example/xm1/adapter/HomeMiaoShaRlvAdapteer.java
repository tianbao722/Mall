package com.example.xm1.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xm1.R;
import com.example.xm1.base.BaseAdapter;
import com.example.xm1.bean.HomeBean;

import java.util.List;

import butterknife.BindView;

public class HomeMiaoShaRlvAdapteer extends BaseAdapter {


    public HomeMiaoShaRlvAdapteer(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.item2_rlv_home_rlv;
    }

    @Override
    protected void bindData(BaseViewHolder viewHolder, Object o) {
        ImageView img = (ImageView) viewHolder.getViewById(R.id.iv_img_item2_home_rlv);
        TextView jiage = (TextView) viewHolder.getViewById(R.id.tv_jiage_item2_rlv);
        TextView miao = (TextView) viewHolder.getViewById(R.id.tv_miao_item2_rlv);
        TextView name = (TextView) viewHolder.getViewById(R.id.tv_item2_name);
        TextView jieshao = (TextView) viewHolder.getViewById(R.id.tv_item2_jieshao);
        HomeBean.DataBean.HotProductListBean bean = (HomeBean.DataBean.HotProductListBean) o;
        Glide.with(context).load(bean.getPic()).into(img);
        jiage.setText("¥" + bean.getOriginalPrice());
        miao.setText("秒杀价 ¥" + bean.getPrice());
        name.setText(bean.getName());
        jieshao.setText(bean.getSubTitle());
    }
}
