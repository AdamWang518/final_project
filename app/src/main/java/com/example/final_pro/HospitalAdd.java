package com.example.final_pro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;
public class HospitalAdd extends AppCompatActivity{
    EditText Name;
    EditText City;
    EditText Town;
    EditText Road;
    EditText Latitude;
    EditText Longitude;
    Button Save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        findViews();
        Save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name, city,town,road,latitude,longitude;
                name = String.valueOf(Name.getText().toString());
                city= String.valueOf(City.getText().toString());
                town= String.valueOf(Town.getText().toString());
                road= String.valueOf(Road.getText().toString());
                latitude= String.valueOf(Latitude.getText().toString());
                longitude= String.valueOf(Longitude.getText().toString());
                float Slatitude=Float.parseFloat(latitude);
                float Slongitude=Float.parseFloat(longitude);
                String type = getSharedPreferences("type", MODE_PRIVATE)
                        .getString("H", "");
                if(name.equals("") || city.equals("")|| town.equals("")|| road.equals("")|| latitude.equals("")|| longitude.equals("")){
                    Toast.makeText(HospitalAdd.this, "欄位不能是空白", Toast.LENGTH_SHORT).show();
                }
                else{
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "name";
                            field[1] = "city";
                            field[2] = "town";
                            field[2] = "road";
                            //Creating array for data
                            String[] data = new String[6];
                            data[0] = name;
                            data[1] = city;
                            field[1] = town;
                            field[1] = road;
                            if(type.equals("H"))
                            {

                            }
                            PutData putData = new PutData("http://52.203.34.134/Loginregister/signup.php", "POST", field, data);//url要改成自己的本機ip
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")) {
                                        Toast.makeText(getApplicationContext(), "註冊成功", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(),"註冊失敗", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });

                }
            }
        });
    }
    private void findViews() {
        Name=(EditText) findViewById(R.id.name);
        City=(EditText) findViewById(R.id.city);
        Town=(EditText) findViewById(R.id.town);
        Road=(EditText) findViewById(R.id.road);
        Latitude=(EditText) findViewById(R.id.latitude);
        Longitude=(EditText) findViewById(R.id.longitude);
        Save=(Button) findViewById(R.id.save_button);
    }
}
