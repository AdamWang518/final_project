package com.example.final_pro;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
public class Choose extends AppCompatActivity{
    private Button Police;
    private Button Fire;
    private Button Emergency;
    private Button Hospital;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;
        networkInfo = connMgr.getActiveNetworkInfo();
        Police=findViewById(R.id.Policebutton);
        Fire=findViewById(R.id.Firebutton);
        Emergency=findViewById(R.id.Emergencybutton);
        Hospital=findViewById(R.id.Hospitalbutton);
        Hospital.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (networkInfo != null && networkInfo.isAvailable()) {
                    String type="H";
                    SharedPreferences pref = getSharedPreferences("type", MODE_PRIVATE);
                    pref.edit()
                            .putString("type", type)
                            .commit();
                    Intent intent = new Intent(Choose.this, Manager.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Choose.this, "請連接網路", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Fire.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (networkInfo != null && networkInfo.isAvailable()) {
                    //連接線上資料庫並更新
                    Intent intent = new Intent(Choose.this, Manager.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Choose.this, "請連接網路", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Emergency.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (networkInfo != null && networkInfo.isAvailable()) {
                    //連接線上資料庫並更新
                    Intent intent = new Intent(Choose.this, Manager.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Choose.this, "請連接網路", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Police.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (networkInfo != null && networkInfo.isAvailable()) {
                    //連接線上資料庫並更新
                    Intent intent = new Intent(Choose.this, Manager.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Choose.this, "請連接網路", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
