package com.example.thebimzz.kasir;

/*
   The Bimzz
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText iga,ayam,gulai,spageti,mendoan,esTeh,rujak;
    Intent i1;
    String jIga,jAyam,jGulai,jSpageti,jMendoan,jEsTeh,jRujak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i1 = new Intent(this,SettingHarga.class);
            this.startActivity(i1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void hitungHarga(View view) {
        i1 = new Intent(this,StrukPembayaran.class);
        ayam = (EditText)findViewById(R.id.jumlahAyam);
        iga = (EditText)findViewById(R.id.jumlahIga);
        gulai = (EditText)findViewById(R.id.jumlahGulai);
        spageti = (EditText)findViewById(R.id.jumlahSpageti);
        mendoan = (EditText)findViewById(R.id.jumlahMendoan);
        esTeh = (EditText)findViewById(R.id.jumlahEsTeh);
        rujak = (EditText)findViewById(R.id.jumlahRujak);

        jAyam = ayam.getText().toString();
        jIga = iga.getText().toString();
        jGulai = gulai.getText().toString();
        jSpageti = spageti.getText().toString();
        jMendoan = mendoan.getText().toString();
        jEsTeh = esTeh.getText().toString();
        jRujak = rujak.getText().toString();

        i1.putExtra("ayam",jAyam);
        i1.putExtra("iga",jIga);
        i1.putExtra("gulai",jGulai);
        i1.putExtra("spageti",jSpageti);
        i1.putExtra("mendoan",jMendoan);
        i1.putExtra("esteh",jEsTeh);
        i1.putExtra("rujak",jRujak);

        this.startActivity(i1);

    }


}
