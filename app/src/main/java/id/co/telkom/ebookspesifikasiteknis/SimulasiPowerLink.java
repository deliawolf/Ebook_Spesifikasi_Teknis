package id.co.telkom.ebookspesifikasiteknis;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class SimulasiPowerLink extends AppCompatActivity {

    private RelativeLayout hasilrx;
    private double tx, pk, sbn, knk, rx;
    private double hasil_pk, hasil_sbn, hasil_knk;
    private String tx_str, pk_str, sbn_str, knk_str;
    private EditText edt_tx, edt_pk, edt_sbn, edt_knk;
    private EditText et_hasilpk, et_hasilsbn, et_hasilknk, et_hasilrx;
    private TextView txt_rx;
    public Button btn_hitungrx;
    final double def_pk = 0.35;
    final double def_sbn = 0.1;
    final double def_knk = 0.25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simulasi);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Simulasi Power Link Budget");


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

        //set layout hasil perhitungan rx jadi invisible
        hasilrx = findViewById(R.id.layout_rx);
        hasilrx.setVisibility(View.GONE);

        edt_tx = findViewById(R.id.et_tx);
        edt_pk = findViewById(R.id.et_pk);
        edt_sbn = findViewById(R.id.et_js);
        edt_knk = findViewById(R.id.et_jk);

        et_hasilpk = findViewById(R.id.et_hsl_pk);
        et_hasilpk.setVisibility(View.GONE);

        et_hasilsbn = findViewById(R.id.et_hsl_js);
        et_hasilsbn.setVisibility(View.GONE);

        et_hasilknk = findViewById(R.id.et_hsl_jk);
        et_hasilknk.setVisibility(View.GONE);

        txt_rx = findViewById(R.id.txt_rumus_rx);

        et_hasilrx = findViewById(R.id.et_hsl_rx);

        btn_hitungrx = findViewById(R.id.button_hitungrx);
        btn_hitungrx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung_rx();
            }
        });

    }

    @SuppressLint("SetTextI18n")
    public void hitung_rx() {
        if (!edt_tx.getText().toString().isEmpty() && !edt_pk.getText().toString().isEmpty() &&
                !edt_sbn.getText().toString().isEmpty() && !edt_knk.getText().toString().isEmpty()) {

            tx_str = edt_tx.getText().toString();
            pk_str = edt_pk.getText().toString();
            sbn_str = edt_sbn.getText().toString();
            knk_str = edt_knk.getText().toString();

            try {
                tx = Double.parseDouble(tx_str);
                pk = Double.parseDouble(pk_str);
                sbn = Double.parseDouble(sbn_str);
                knk = Double.parseDouble(knk_str);
            } catch (Exception e1) {

                e1.printStackTrace();
            }

            hasil_pk = pk * def_pk;
            hasil_sbn = sbn * def_sbn;
            hasil_knk = knk * def_knk;

            rx = tx - (hasil_pk + hasil_sbn + hasil_knk);

            txt_rx.setText("Rx = " + tx_str + " - (" + new DecimalFormat("##.##").format(hasil_pk) + " + "
                    + new DecimalFormat("##.##").format(hasil_sbn) + " + "
                    + new DecimalFormat("##.##").format(hasil_knk) + ")");


            et_hasilpk.setText(Double.toString(Double.parseDouble(new DecimalFormat("##.##").format(hasil_pk))));
            et_hasilpk.setVisibility(View.VISIBLE);

            et_hasilsbn.setText(Double.toString(Double.parseDouble(new DecimalFormat("##.##").format(hasil_sbn))));
            et_hasilsbn.setVisibility(View.VISIBLE);

            et_hasilknk.setText(Double.toString(Double.parseDouble(new DecimalFormat("##.##").format(hasil_knk))));
            et_hasilknk.setVisibility(View.VISIBLE);

            et_hasilrx.setText(Double.toString(Double.parseDouble(new DecimalFormat("##.##").format(rx))));

            hasilrx.setVisibility(View.VISIBLE);

        } else {
            Toast.makeText(SimulasiPowerLink.this, "Field inputan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
        }
    }
}
