package com.example.thebimzz.kasir;

/*
   The Bimzz
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class StrukPembayaran extends AppCompatActivity {
    String hargaIga1,hargaAyam1,hargaGulai1,hargaSpageti1,hargaMendoan1,hargaEsTeh1,hargaRujak1;
    String hargaIga,hargaAyam,hargaGulai,hargaSpageti,hargaMendoan,hargaEsTeh,hargaRujak;
    TextView gulai,ayam,iga,spageti,mendoan,esteh,rujak;
    int totGulai,totAyam,totIga,totSpageti,totMendoan,totEsteh,totRujak;
    Intent intent;
    public static String MY_PREFS = "MY_PREFS";
    public SharedPreferences pref;
    int prefMode = SettingHarga.MODE_PRIVATE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk_pembayaran);



    }

    @Override
    protected void onStart() {
        super.onStart();
        intent = getIntent();
        Bundle b = intent.getExtras();
        pref = getSharedPreferences(MY_PREFS,prefMode);

        if(b!=null){
            hargaAyam = (String)b.get("ayam");
            hargaIga = (String)b.get("iga");
            hargaGulai = (String)b.get("gulai");
            hargaSpageti = (String)b.get("spageti");
            hargaMendoan = (String)b.get("mendoan");
            hargaEsTeh = (String)b.get("esteh");
            hargaRujak = (String)b.get("rujak");
        }



        hargaAyam1 = pref.getString("ayam","1");
        hargaIga1 = pref.getString("iga","1");
        hargaGulai1 = pref.getString("gulai","1");
        hargaSpageti1 = pref.getString("spageti","1");
        hargaMendoan1 = pref.getString("mendoan","1");
        hargaEsTeh1 = pref.getString("esTeh","1");
        hargaRujak1 = pref.getString("rujak","1");

        ayam = (TextView)findViewById(R.id.totalAyam);
        gulai = (TextView)findViewById(R.id.totalGulai);
        iga = (TextView)findViewById(R.id.totalIga);
        spageti = (TextView)findViewById(R.id.totalSpagheti);
        mendoan = (TextView)findViewById(R.id.totalMendoan);
        esteh = (TextView)findViewById(R.id.totalEsTeh);
        rujak = (TextView)findViewById(R.id.totalRujak);

        //totGulai = Integer.parseInt(hargaGulai)*Integer.parseInt(pref.getString("gulai","0"));

        totGulai = Integer.parseInt(hargaGulai)*Integer.parseInt(hargaGulai1);
        totAyam = Integer.parseInt(hargaAyam)*Integer.parseInt(hargaAyam1);
        totIga = Integer.parseInt(hargaIga)*Integer.parseInt(hargaIga1);
        totEsteh = Integer.parseInt(hargaEsTeh)*Integer.parseInt(hargaEsTeh1);
        totRujak = Integer.parseInt(hargaRujak)*Integer.parseInt(hargaRujak1);
        totSpageti = Integer.parseInt(hargaSpageti)*Integer.parseInt(hargaSpageti1);
        totMendoan = Integer.parseInt(hargaMendoan)*Integer.parseInt(hargaMendoan1);

        gulai.setText(Integer.toString(totGulai));
        ayam.setText(Integer.toString(totAyam));
        iga.setText(Integer.toString(totIga));
        spageti.setText(Integer.toString(totSpageti));
        mendoan.setText(Integer.toString(totMendoan));
        rujak.setText(Integer.toString(totRujak));
        esteh.setText(Integer.toString(totEsteh));

        TextView totHarga = (TextView)findViewById(R.id.totalHarga);
        String totalHarga= Integer.toString(totGulai+totAyam+totIga+totSpageti+totMendoan+totEsteh+totRujak);
        totHarga.setText(totalHarga);

    }
}
