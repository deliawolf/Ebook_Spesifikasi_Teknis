package id.co.telkom.ebookspesifikasiteknis;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MenuUtama extends AppCompatActivity {

    private LinearLayout ftth, feeder, distribusi, drop, simulasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Menu Utama");
        
        ftth = findViewById(R.id.button_overview_ftth);
        ftth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, OverviewFTTH.class);
                startActivity(intent);
            }
        });

        feeder = findViewById(R.id.button_segment_feeder);
        feeder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, SegmentFeeder.class);
                startActivity(intent);
            }
        });

        distribusi = findViewById(R.id.button_segment_distribusi);
        distribusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, SegmentDistribusi.class);
                startActivity(intent);
            }
        });

        drop = findViewById(R.id.button_segment_drop);
        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, SegmentDrop.class);
                startActivity(intent);
            }
        });

        simulasi = findViewById(R.id.button_sim_power_link);
        simulasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, SimulasiPowerLink.class);
                startActivity(intent);
            }
        });

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

}