package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText id,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        id = (EditText)findViewById(R.id.id);
        pwd = (EditText)findViewById(R.id.pwd);
    }
    public void registerok(View view){
        SharedPreferences result = getSharedPreferences("personal",0);
        String userid = id.getText().toString();
        String userpwd = pwd.getText().toString();
        result.edit()
                .putString("uid",userid)
                .putString("upwd",userpwd)
                .commit();
        finish();

    }
    public void cancel(View view){
        finish();
    }
}