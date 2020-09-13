package com.example.xm1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.xm1.ui.classify.ClassifyFragment;
import com.example.xm1.ui.home.HomeFragment;
import com.example.xm1.ui.my.MyFragment;
import com.example.xm1.ui.special.SpecialFragment;
import com.example.xm1.utiles.SpUtils;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tab)
    TabLayout tab;
    private FragmentManager manager;
    private HomeFragment homeFragment;
    private ClassifyFragment classifyFragment;
    private SpecialFragment specialFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPermiss();
        initView();
    }

    //请求权限
    private void initPermiss() {
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {
                Toast.makeText(MainActivity.this, "请求权限成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {
                Toast.makeText(MainActivity.this, "请求权限失败", Toast.LENGTH_SHORT).show();
            }
        }, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE});
    }

    private void initView() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        homeFragment = new HomeFragment();
        classifyFragment = new ClassifyFragment();
        specialFragment = new SpecialFragment();
        myFragment = new MyFragment();
        transaction.add(R.id.fl, homeFragment);//首页
        transaction.add(R.id.fl, classifyFragment);//分类
        transaction.add(R.id.fl, specialFragment);//专题
        transaction.add(R.id.fl, myFragment);//我的
        transaction.show(homeFragment);
        transaction.hide(classifyFragment);
        transaction.hide(specialFragment);
        transaction.hide(myFragment);
        transaction.commit();
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.tab1));
        tab.addTab(tab.newTab().setText("分类").setIcon(R.drawable.tab2));
        tab.addTab(tab.newTab().setText("专题").setIcon(R.drawable.tab3));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.tab4));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                TextView textView = new TextView(MainActivity.this);
//                float v = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 16, getResources().getDisplayMetrics());
//                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,v);
//                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
//                textView.setText(tab.getText());
//                tab.setCustomView(textView);
                switch (tab.getPosition()) {
                    case 0:
                        manager
                                .beginTransaction()
                                .show(homeFragment)
                                .hide(classifyFragment)
                                .hide(specialFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case 1:
                        manager
                                .beginTransaction()
                                .show(classifyFragment)
                                .hide(homeFragment)
                                .hide(specialFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case 2:
                        manager
                                .beginTransaction()
                                .show(specialFragment)
                                .hide(classifyFragment)
                                .hide(homeFragment)
                                .hide(myFragment)
                                .commit();
                        break;

                    case 3:
                        manager
                                .beginTransaction()
                                .show(myFragment)
                                .hide(classifyFragment)
                                .hide(specialFragment)
                                .hide(homeFragment)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}