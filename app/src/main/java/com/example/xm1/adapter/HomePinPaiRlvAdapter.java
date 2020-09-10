package com.example.xm1.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
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
        HomeBean.DataBean.NewProductListBean bean = (HomeBean.DataBean.NewProductListBean) o;
        TextView title = (TextView) viewHolder.getViewById(R.id.tv_title_item1);
        TextView jiage = (TextView) viewHolder.getViewById(R.id.tv_jiage);
        ImageView img = (ImageView) viewHolder.getViewById(R.id.iv_img_item1_home);
        String name = bean.getProductCategoryName();
        title.setText(name);
        jiage.setText(bean.getOriginalPrice()+"起");
        Glide.with(context).load(bean.getPic()).into(img);
    }
}
