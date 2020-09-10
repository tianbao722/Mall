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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.example.xm1.R;
import com.example.xm1.bean.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePinPaiAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private List<HomeBean.DataBean.BrandListBean> listBeans;

    public HomePinPaiAdapter(Context context, LayoutHelper layoutHelper, List<HomeBean.DataBean.BrandListBean> listBeans) {
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
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1_rlv_home, parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        HomePinPaiRlvAdapter homePinPaiRlvAdapter = new HomePinPaiRlvAdapter(context, listBeans);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        viewHolder.rlvHomeRlv.setLayoutManager(gridLayoutManager);
        viewHolder.rlvHomeRlv.setAdapter(homePinPaiRlvAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_pinpai)
        TextView tvPinpai;
        @BindView(R.id.tv_gengduo)
        TextView tvGengduo;
        @BindView(R.id.rlv_home_rlv)
        RecyclerView rlvHomeRlv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
