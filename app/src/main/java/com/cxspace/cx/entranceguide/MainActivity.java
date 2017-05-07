package com.cxspace.cx.entranceguide;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    WebView wv = null;
    ProgressDialog pd = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wv = (WebView)findViewById(R.id.Toweb);

        WebSettings settings = wv.getSettings();



        settings.setJavaScriptEnabled(true);//启用js
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//js和android交互
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setAppCacheEnabled(true); //设置H5的缓存打开,默认关闭
        settings.setUseWideViewPort(true);//设置webview自适应屏幕大小
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);//设置，可能的话使所有列的宽度不超过屏幕宽度
        settings.setLoadWithOverviewMode(true);//设置webview自适应屏幕大小
        settings.setDomStorageEnabled(true);//设置可以使用localStorage
        settings.setSupportZoom(false);//关闭zoom按钮
        settings.setBuiltInZoomControls(false);//关闭zoom
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            wv.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        if(wv != null)
        {
            wv.setWebViewClient(new WebViewClient()
            {
                @Override
                public void onPageFinished(WebView view,String url)
                {
                    pd.dismiss();
                }
            });

            loadUrl("http://www.cxspace.top/static/select.html");
        }

    }


    public void loadUrl(String url)
    {
        if(wv != null)
        {
            wv.loadUrl(url);

            pd = ProgressDialog.show(this, "温馨提示", "系统加载中(首次启动加载较慢)...");

//            wv.reload();


        }
    }
}
