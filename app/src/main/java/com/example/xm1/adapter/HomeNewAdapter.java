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

public class HomeNewAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private List<HomeBean.DataBean.NewProductListBean> listBeans;

    public HomeNewAdapter(Context context, LayoutHelper layoutHelper, List<HomeBean.DataBean.NewProductListBean> listBeans) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.item3_home, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        viewHolder.rlv3HomeRlv.setLayoutManager(gridLayoutManager);
        HomeNewRlvAdapter homeNewRlvAdapter = new HomeNewRlvAdapter(context, listBeans);
        viewHolder.rlv3HomeRlv.setAdapter(homeNewRlvAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_new)
        TextView tvNew;
        @BindView(R.id.tv_gengduo_item3)
        TextView tvGengduoItem3;
        @BindView(R.id.rlv3_home_rlv)
        RecyclerView rlv3HomeRlv;
        @BindView(R.id.v_rlv)
        View vRlv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
