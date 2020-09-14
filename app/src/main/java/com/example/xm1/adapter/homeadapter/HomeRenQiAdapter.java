package com.example.xm1.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.xm1.R;
import com.example.xm1.bean.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeRenQiAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private List<HomeBean.DataBean.NewProductListBean> listBeans;

    public HomeRenQiAdapter(Context context, LayoutHelper layoutHelper, List<HomeBean.DataBean.NewProductListBean> listBeans) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.item4_home, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        viewHolder.rlv4Home.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
        viewHolder.rlv4Home.setLayoutManager(linearLayoutManager);
        HomeRenQiRlvAdapter homeRenQiRlvAdapter = new HomeRenQiRlvAdapter(context, listBeans);
        viewHolder.rlv4Home.setAdapter(homeRenQiRlvAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_renqi)
        TextView tvRenqi;
        @BindView(R.id.tv_gengduo_item4)
        TextView tvGengduoItem4;
        @BindView(R.id.v_item4)
        View vItem4;
        @BindView(R.id.rlv4_home)
        RecyclerView rlv4Home;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
