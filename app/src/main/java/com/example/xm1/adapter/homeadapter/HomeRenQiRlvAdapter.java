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

public class HomeRenQiRlvAdapter extends BaseAdapter {


    public HomeRenQiRlvAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.item4_home_rlv;
    }

    @Override
    protected void bindData(BaseViewHolder viewHolder, Object o) {
        ImageView img = (ImageView) viewHolder.getViewById(R.id.iv_img_item4_home);
        TextView title = (TextView) viewHolder.getViewById(R.id.tv_title_item4);
        TextView jieshao = (TextView) viewHolder.getViewById(R.id.tv_jieshao_item4);
        TextView jiage = (TextView) viewHolder.getViewById(R.id.tv_jiage_item4_rlv);
        TextView xuanze = (TextView) viewHolder.getViewById(R.id.tv_xuanze);
        HomeBean.DataBean.NewProductListBean bean = (HomeBean.DataBean.NewProductListBean) o;
        Glide.with(context).load(bean.getPic()).into(img);
        title.setText(bean.getName());
        jieshao.setText(bean.getSubTitle());
        jiage.setText("¥" + bean.getOriginalPrice());
        xuanze.setText(bean.getPromotionType() + "色可选");
    }
}
