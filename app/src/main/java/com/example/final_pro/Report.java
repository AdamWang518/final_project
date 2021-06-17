package com.example.final_pro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Report extends AppCompatActivity {
    private ListView Views;
    private Button add;
    // private ReportDb reportDb;//資料庫
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        Views = (ListView) findViewById(R.id.report_list);
        add = (Button) findViewById(R.id.add_button);
        //setView();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Report.this, com.example.final_pro.ReportWriter.class);
                startActivity(intent);
                finish();
            }
        });
    }


  /*  private void setView(){
        if(reportDb == null) {
            //建立資料庫
        }
        //將文字連接到資料庫並顯示
    }*/
}
