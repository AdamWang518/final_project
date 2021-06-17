package com.example.final_pro;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AfterLog extends AppCompatActivity {
    private Button logout;
    private Button search;
    private Button update;
    private Button report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlog);
        logout = findViewById(R.id.button7);
        search = findViewById(R.id.button2);
        report = findViewById(R.id.button8);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;
        networkInfo = connMgr.getActiveNetworkInfo();

        update=findViewById(R.id.button3);
        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (networkInfo != null && networkInfo.isAvailable()) {
                    //取得最新資料
                }
                else {
                    Toast.makeText(AfterLog.this, "請連接網路", Toast.LENGTH_SHORT).show();
                }
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AfterLog.this, com.example.final_pro.Search.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AfterLog.this, com.example.final_pro.MainActivity.class);
                startActivity(intent);
                finish();
                //登出資料庫
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AfterLog.this, com.example.final_pro.Report.class);
                startActivity(intent);
            }
        });

    }
}