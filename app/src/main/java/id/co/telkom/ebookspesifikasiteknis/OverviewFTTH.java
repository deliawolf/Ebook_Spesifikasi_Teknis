package id.co.telkom.ebookspesifikasiteknis;

import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;


public class OverviewFTTH extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_ftth);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Overview Jaringan FTTH");


        // Tambah panah kembali
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final WebView webView = findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/test.html");

    }
}