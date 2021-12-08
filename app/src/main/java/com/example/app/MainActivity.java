package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button cancel;
    private EditText id,pwd;
    private String loginid,loginpwd;
    private  Boolean loggedin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText)findViewById(R.id.id);
        pwd = (EditText)findViewById(R.id.pwd);
        cancel = (Button)findViewById(R.id.cancel);
        SharedPreferences result = getSharedPreferences("personal",0);
        loggedin = result.getBoolean("loggedin",false);
        if (loggedin){
            Intent it = new Intent(MainActivity.this,MainActivity3.class);
            startActivity(it);
        }
    }
    public void login(View view){
        SharedPreferences result = getSharedPreferences("personal",0);
        loginid = result.getString("uid","無");
        loginpwd = result.getString("upwd","無");
        if (loginid.equals(id.getText().toString())){
            if (loginpwd.equals(pwd.getText().toString())){
                result.edit().putBoolean("loggedin",true).commit();
                Intent it = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(it);
            }
        }


    }
    public void register(View view){
        SharedPreferences result = getSharedPreferences("personal",0);

        if (result.contains("uid")){
            if (result.contains("upwd")) {
                AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
                d.setTitle("警告!")
                        .setMessage("已註冊")
                        .setCancelable(false);
                d.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                d.show();
            }
        }else {
            Intent it = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(it);
        }
    }
}
