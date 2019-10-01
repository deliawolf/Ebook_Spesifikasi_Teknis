package id.co.telkom.ebookspesifikasiteknis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        String nama_apps = "<font color=#707070>Spesifikasi</font> <font color=#D51200>Teknis</font>";
        TextView nama_app = findViewById(R.id.nama_app);
        nama_app.setText(Html.fromHtml(nama_apps));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MenuUtama.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
