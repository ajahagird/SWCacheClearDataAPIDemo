package com.example.swcachecleardataapidemo;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView.setWebContentsDebuggingEnabled(true);

        final WebView webView = findViewById(R.id.webview);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://massive-delirious-wish.glitch.me");

        Button button = findViewById(R.id.clear_webview_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebStorage.getInstance().deleteAllData();
                webView.clearCache(true);
                webView.reload();
            }
        });
    }
}