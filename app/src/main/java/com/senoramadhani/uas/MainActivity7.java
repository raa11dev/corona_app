package com.senoramadhani.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {
    private WebView webview2;
    private String url = "https://covid19.go.id/storage/app/media/Protokol/2020/Juli/REV-05_Pedoman_P2_COVID-19_13_Juli_2020.pdf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        webview2 = findViewById(R.id.webView2);
        //function untuk menampilkan pdf dalam webview
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        webview2.requestFocus();
        webview2.getSettings().setJavaScriptEnabled(true);
        webview2.loadUrl("https://docs.google.com/gview?embedded=true&url="+ url);
    }
    //function jika di oencet kembali, akan kembali ke mainactivity6
    public void onBackPressed() {
        if(webview2.canGoBack()) {
            webview2.goBack();
        } else{
            finish();
        }
    }

}