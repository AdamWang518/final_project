package com.example.final_pro;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
                Intent intent = new Intent(HospitalManager.this, HospitalAdd.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
