package com.example.final_pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;



public class HospitalManager extends AppCompatActivity {
    private Button alter;
    private Button add;
    private Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospitalmanager);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;
        networkInfo = connMgr.getActiveNetworkInfo();
        alter=findViewById(R.id.alter_button);
        add=findViewById(R.id.add_button);
        delete=findViewById(R.id.delete_button);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String type="H";
                SharedPreferences pref = getSharedPreferences("type", MODE_PRIVATE);
                pref.edit()
                        .putString("H", type)
                        .commit();
                Intent intent = new Intent(HospitalManager.this, HospitalAdd.class);
                startActivity(intent);
                finish();
            }
        });
        alter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HospitalManager.this, HospitalAdd.class);
                startActivity(intent);
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HospitalManager.this, HospitalAdd.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
