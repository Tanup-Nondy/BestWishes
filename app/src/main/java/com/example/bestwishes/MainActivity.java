package com.example.bestwishes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button msbtn,imgbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msbtn=findViewById(R.id.msg_btn);
        msbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Options_Activity.class);
                startActivity(i);
            }
        });
        imgbtn=findViewById(R.id.img_btn);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Cake_Activity.class);
                startActivity(i);
            }
        });
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
