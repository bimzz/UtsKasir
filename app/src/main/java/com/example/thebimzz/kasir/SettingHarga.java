package com.example.thebimzz.kasir;

/*
   The Bimzz
 */

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingHarga extends AppCompatActivity {

    public static String MY_PREFS = "MY_PREFS";
    public SharedPreferences pref;
    int prefMode = SettingHarga.MODE_PRIVATE;
    EditText iga,ayam,gulai,spageti,mendoan,esTeh,rujak;
    String hargaIga,hargaAyam,hargaGulai,hargaSpageti,hargaMendoan,hargaEsTeh,hargaRujak;
    Button simpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_harga);
    }

    public void simpanHarga(View view) {
        iga = (EditText)findViewById(R.id.hargaIga);
        gulai = (EditText)findViewById(R.id.hargaGulai);
        ayam = (EditText)findViewById(R.id.hargaAyam);
        spageti = (EditText)findViewById(R.id.hargaSphageti);
        mendoan = (EditText)findViewById(R.id.hargaMendoan);
        esTeh = (EditText)findViewById(R.id.hargaEsTeh);
        rujak = (EditText)findViewById(R.id.hargaRujak);
        hargaAyam = ayam.getText().toString();
        hargaIga = iga.getText().toString();
        hargaGulai = gulai.getText().toString();
        hargaSpageti = spageti.getText().toString();
        hargaMendoan = mendoan.getText().toString();
        hargaEsTeh = esTeh.getText().toString();
        hargaRujak = rujak.getText().toString();

        pref = getSharedPreferences(MY_PREFS,prefMode);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("iga",hargaIga);
        editor.putString("ayam",hargaAyam);
        editor.putString("gulai",hargaGulai);
        editor.putString("mendoan",hargaMendoan);
        editor.putString("spageti",hargaSpageti);
        editor.putString("rujak",hargaRujak);
        editor.putString("esTeh",hargaEsTeh);

        //ayam.setText(pref.getString("iga","222"));
        editor.commit();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onStart() {
        pref = getSharedPreferences(MY_PREFS,prefMode);
        iga = (EditText)findViewById(R.id.hargaIga);
        gulai = (EditText)findViewById(R.id.hargaGulai);
        ayam = (EditText)findViewById(R.id.hargaAyam);
        spageti = (EditText)findViewById(R.id.hargaSphageti);
        mendoan = (EditText)findViewById(R.id.hargaMendoan);
        esTeh = (EditText)findViewById(R.id.hargaEsTeh);
        rujak = (EditText)findViewById(R.id.hargaRujak);


        mendoan.setText(pref.getString("mendoan","1"));
        spageti.setText(pref.getString("spageti","1"));
        ayam.setText(pref.getString("ayam","1"));
        gulai.setText(pref.getString("gulai","1"));
        iga.setText(pref.getString("iga","1"));
        rujak.setText(pref.getString("rujak","1"));
        esTeh.setText(pref.getString("esTeh","1"));
        super.onStart();
    }
}
