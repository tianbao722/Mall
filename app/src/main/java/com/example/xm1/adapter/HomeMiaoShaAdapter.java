package com.example.xm1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.xm1.R;
import com.example.xm1.bean.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeMiaoShaAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private List<HomeBean.DataBean.HotProductListBean> listBeans;

    public HomeMiaoShaAdapter(Context context, LayoutHelper layoutHelper, List<HomeBean.DataBean.HotProductListBean> listBeans) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.item2_rlv_home, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        viewHolder.rlv1HomeRlv.setLayoutManager(gridLayoutManager);
        HomeMiaoShaRlvAdapteer homeMiaoShaRlvAdapteer = new HomeMiaoShaRlvAdapteer(context, listBeans);
        viewHolder.rlv1HomeRlv.setAdapter(homeMiaoShaRlvAdapteer);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_pinpai)
        TextView tvPinpai;
        @BindView(R.id.tv_shengyu)
        TextView tvShengyu;
        @BindView(R.id.tv_start)
        TextView tvStart;
        @BindView(R.id.tv_shi)
        TextView tvShi;
        @BindView(R.id.tv_fen)
        TextView tvFen;
        @BindView(R.id.tv_miao)
        TextView tvMiao;
        @BindView(R.id.rlv1_home_rlv)
        RecyclerView rlv1HomeRlv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
