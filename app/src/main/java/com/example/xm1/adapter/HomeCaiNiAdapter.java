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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeCaiNiAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private ArrayList<HomeBean.DataBean.NewProductListBean> listBeans;

    public HomeCaiNiAdapter(Context context, LayoutHelper layoutHelper, ArrayList<HomeBean.DataBean.NewProductListBean> listBeans) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.item6_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        viewHolder.rlv6Home.setLayoutManager(gridLayoutManager);
        HomeCaiNiRlvAdapter homeCaiNiRlvAdapter = new HomeCaiNiRlvAdapter(context, listBeans);
        viewHolder.rlv6Home.setAdapter(homeCaiNiRlvAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_caini)
        TextView tvCaini;
        @BindView(R.id.rlv6_home)
        RecyclerView rlv6Home;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
