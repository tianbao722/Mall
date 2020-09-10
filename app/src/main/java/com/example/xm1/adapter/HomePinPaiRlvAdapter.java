package com.example.xm1.adapter;

import android.content.Context;
import android.text.TextUtils;
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
        HomeBean.DataBean.BrandListBean bean = (HomeBean.DataBean.BrandListBean) o;
        TextView title = (TextView) viewHolder.getViewById(R.id.tv_title_item1);
        TextView jiage = (TextView) viewHolder.getViewById(R.id.tv_jiage);
        ImageView img = (ImageView) viewHolder.getViewById(R.id.iv_img_item1_home);
        title.setText(bean.getName());
        jiage.setText("299起");
        String bigPic = bean.getBigPic();
        if (TextUtils.isEmpty(bigPic)) {
            Glide.with(context).load(R.mipmap.u88).into(img);
        } else {
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(context).load(bigPic).into(img);
        }
    }
}
