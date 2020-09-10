package com.example.xm1.base;


import com.example.xm1.app.MyApp;

import java.io.File;
import java.util.ArrayList;

public class ConStants {
    public static final String Base_HomeUrl = "http://169.254.96.147:8085/";
    public static final String Base_UserUrl = "http://cdwan.cn:9001/"; //用户信息相关的基础地址

    public static final String Base_UploadUrl = "http://yun918.cn/study/public/";  //资源上传的基础地址
    //网络缓存地址
    public static final String PATH_DATA = MyApp.app.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/XM1";
}
