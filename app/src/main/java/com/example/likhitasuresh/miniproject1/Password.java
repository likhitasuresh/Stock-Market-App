package com.example.likhitasuresh.miniproject1;

import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.content.Intent;
import android.widget.TextView;
import android.widget.*;
import android.widget.Toast;


public class Password extends AppCompatActivity {

    TextView a;

    SharedPreferences currpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_password);
        a=(TextView)findViewById(R.id.tv1);
        currpass = getApplicationContext().getSharedPreferences("password",MODE_PRIVATE);
        SharedPreferences.Editor ed = currpass.edit();
        ed.putString("password","0000");
        ed.apply();
    }
    public void f1(View V)
    {
        String p = a.getText().toString();
        String p1 = currpass.getString("password","");

        if(p.equals(p1))
        {
            Intent i = new Intent(getApplicationContext(),home1.class);
            i.putExtra("1","1");
            a.setText(null);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this,"Wrong Password!",Toast.LENGTH_LONG).show();
            a.setText(null);
        }
    }
}
