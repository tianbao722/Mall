package com.example.xm1.adapter;

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

public class HomePinPaiRlvAdapter extends BaseAdapter {


    public HomePinPaiRlvAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.item1_rlv_home_pinpai;
    }

    @Override
    protected void bindData(BaseViewHolder viewHolder, Object o) {
        HomeBean.DataBean.BrandListBean bean = (HomeBean.DataBean.BrandListBean) o;
        TextView title = (TextView) viewHolder.getViewById(R.id.tv_title_item1);
        TextView jiage = (TextView) viewHolder.getViewById(R.id.tv_jiage);
        ImageView img = (ImageView) viewHolder.getViewById(R.id.iv_img_item1_home);
        String name = bean.getName();
        title.setText(name);
        jiage.setText("3999.99起");
        Glide.with(context).load(bean.getBigPic()).into(img);
    }
}
