package com.example.final_pro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

public class HospitalAdd extends AppCompatActivity{
    EditText Name;
    EditText City;
    EditText Town;
    EditText Road;
    EditText Latitude;
    EditText Longitude;
    Button Save;
    RequestQueue queue;
    String type;
    String name, city,town,road,latitude,longitude;
    float Slatitude,Slongitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        findViews();
        queue = Volley.newRequestQueue(this);
        type = getSharedPreferences("type", MODE_PRIVATE).getString("type", "");
        Save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                name = String.valueOf(Name.getText().toString());
                city= String.valueOf(City.getText().toString());
                town= String.valueOf(Town.getText().toString());
                road= String.valueOf(Road.getText().toString());
                latitude= String.valueOf(Latitude.getText().toString());
                longitude= String.valueOf(Longitude.getText().toString());
                Slatitude=Float.parseFloat(latitude);
                Slongitude=Float.parseFloat(longitude);
                if(type.equals("H"))
                {
                    String url = "http://192.168.50.36/Loginregister/location.php";
                    JSONObject object = new JSONObject();
                    try {
                        object.put("city",city);
                        object.put("town",town);
                        object.put("road",road);
                        object.put("latitude",Slatitude);
                        object.put("longitude",Slongitude);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("HKTJSON",e.getMessage());
                    }
                    sendRequest(url, object, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("HKTSUCCESS",response.toString());
                            sendPlaceRequest();
                            Toast.makeText(HospitalAdd.this, "新增成功", Toast.LENGTH_SHORT).show();
                        }

                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("HKTERRO",error.getMessage());
                            Toast.makeText(HospitalAdd.this, "新增失敗", Toast.LENGTH_SHORT).show();
                        }
                    });


                }












//
//                String type = getSharedPreferences("type", MODE_PRIVATE)
//                        .getString("H", "");
//                if(name.equals("") || city.equals("")|| town.equals("")|| road.equals("")|| latitude.equals("")|| longitude.equals("")){
//                    Toast.makeText(HospitalAdd.this, "欄位不能是空白", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Handler handler = new Handler(Looper.getMainLooper());
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            //Starting Write and Read data with URL
//                            //Creating array for parameters
//                            String[] field = new String[4];
//                            field[0] = "name";
//                            field[1] = "city";
//                            field[2] = "town";
//                            field[2] = "road";
//                            //Creating array for data
//                            String[] data = new String[6];
//                            data[0] = name;
//                            data[1] = city;
//                            field[1] = town;
//                            field[1] = road;
//                            if(type.equals("H"))
//                            {
//
//                            }
//                            PutData putData = new PutData("http://52.203.34.134/Loginregister/signup.php", "POST", field, data);//url要改成自己的本機ip
//                            if (putData.startPut()) {
//                                if (putData.onComplete()) {
//                                    String result = putData.getResult();
//                                    if (result.equals("Sign Up Success")) {
//                                        Toast.makeText(getApplicationContext(), "註冊成功", Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                                        startActivity(intent);
//                                        finish();
//                                    } else {
//                                        Toast.makeText(getApplicationContext(),"註冊失敗", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            }
//                            //End Write and Read data with URL
//                        }
//                    });
//
//                }
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


    private void sendRequest(String url, JSONObject object, Response.Listener<JSONObject> listener,
                             @Nullable Response.ErrorListener errorListener){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, object,listener,errorListener );
        queue.add(jsonObjectRequest);
    }
    private void sendPlaceRequest(){
        String url;
        if(type.equals("H"))
        {
            url = "http://192.168.50.36/Loginregister/hospitaladd.php";
            JSONObject object = new JSONObject();
            try {
                object.put("name",name);
                object.put("city",city);
                object.put("town",town);
                object.put("road",road);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("HKTJSON",e.getMessage());
            }
            sendRequest(url,object,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("HKTSUCCESS",response.toString());
                Toast.makeText(HospitalAdd.this, "新增成功", Toast.LENGTH_SHORT).show();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HKTERRO",error.getMessage());
                Toast.makeText(HospitalAdd.this, "新增失敗", Toast.LENGTH_SHORT).show();
            }
        });
        }
        if(type.equals("E"))
        {
            url = "http://192.168.50.36/Loginregister/hospitaladd.php";
            JSONObject object = new JSONObject();
            try {
                object.put("name",name);
                object.put("city",city);
                object.put("town",town);
                object.put("road",road);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("HKTJSON",e.getMessage());
            }
            sendRequest(url,object,new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("HKTSUCCESS",response.toString());
                    Toast.makeText(HospitalAdd.this, "新增成功", Toast.LENGTH_SHORT).show();
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("HKTERRO",error.getMessage());
                    Toast.makeText(HospitalAdd.this, "新增失敗", Toast.LENGTH_SHORT).show();
                }
            });
        }
        if(type.equals("F"))
        {
            url = "http://192.168.50.36/Loginregister/hospitaladd.php";
            JSONObject object = new JSONObject();
            try {
                object.put("name",name);
                object.put("city",city);
                object.put("town",town);
                object.put("road",road);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("HKTJSON",e.getMessage());
            }
            sendRequest(url,object,new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("HKTSUCCESS",response.toString());
                    Toast.makeText(HospitalAdd.this, "新增成功", Toast.LENGTH_SHORT).show();
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("HKTERRO",error.getMessage());
                    Toast.makeText(HospitalAdd.this, "新增失敗", Toast.LENGTH_SHORT).show();
                }
            });
        }
        if(type.equals("P"))
        {
            url = "http://192.168.50.36/Loginregister/hospitaladd.php";
            JSONObject object = new JSONObject();
            try {
                object.put("name",name);
                object.put("city",city);
                object.put("town",town);
                object.put("road",road);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("HKTJSON",e.getMessage());
            }
            sendRequest(url,object,new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("HKTSUCCESS",response.toString());
                    Toast.makeText(HospitalAdd.this, "新增成功", Toast.LENGTH_SHORT).show();
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("HKTERRO",error.getMessage());
                    Toast.makeText(HospitalAdd.this, "新增失敗", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
