package com.example.xm1.adapter.homeadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xm1.R;
import com.example.xm1.bean.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeZhuanTiAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private List<HomeBean.DataBean.NewProductListBean> listBeans;

    public HomeZhuanTiAdapter(Context context, LayoutHelper layoutHelper, List<HomeBean.DataBean.NewProductListBean> listBeans) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.listBeans = listBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item5_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load("http://i1.hdslb.com/bfs/archive/d9f81222ddbd9729d6ef848bcff41f323b0909d5.png").into(viewHolder.ivImgItem5Home);
//        viewHolder.tvNameItem5.setText(listBeans.get(position).getName());
//        viewHolder.tvJiageItem5.setText("¥" + listBeans.get(position).getOriginalPrice() + "元起");
//        viewHolder.tvJieshaoItem5.setText(listBeans.get(position).getSubTitle());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_zhuanti)
        TextView tvZhuanti;
        @BindView(R.id.tv_gengduo_item5)
        TextView tvGengduoItem5;
        @BindView(R.id.iv_img_item5_home)
        ImageView ivImgItem5Home;
        @BindView(R.id.tv_name_item5)
        TextView tvNameItem5;
        @BindView(R.id.tv_jiage_item5)
        TextView tvJiageItem5;
        @BindView(R.id.tv_jieshao_item5)
        TextView tvJieshaoItem5;
        @BindView(R.id.v_rlv)
        View vRlv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
