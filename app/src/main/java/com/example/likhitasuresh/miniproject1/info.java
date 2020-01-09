package com.example.likhitasuresh.miniproject1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class info extends AppCompatActivity {
    TextView tvj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tvj = (TextView)findViewById(R.id.tvab);
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        Bundle b = this.getIntent().getExtras();
        String d = b.getString("name");
        String q=databaseAccess.getAbout(d);
        tvj.setText(q);
        databaseAccess.close();



    }
}
