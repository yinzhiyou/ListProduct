package com.example.yinzhiyou20181204.denglu;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.tencent.bugly.crashreport.CrashReport;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "d78e435636", true);
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSize(50*1024*1024)
                .memoryCacheSizePercentage(13)
                .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                        .showImageOnFail(R.drawable.ic_launcher_background)
                        .showImageOnLoading(R.drawable.ic_launcher_background)
                        .displayer(new RoundedBitmapDisplayer(18))
                        .build()).build());
    }
}
