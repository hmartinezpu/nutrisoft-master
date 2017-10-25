package com.nextu.navegacionweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://www.nutrisoft.xyz/";
        WebView webView = (WebView) findViewById(R.id.webView);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        setTitle("Nutrisoft");
        //url
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int progress){
                progressBar.setProgress(0);
                progressBar.setVisibility(View.VISIBLE);

                progressBar.incrementProgressBy(progress);

                if (progress == 100){
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

}
