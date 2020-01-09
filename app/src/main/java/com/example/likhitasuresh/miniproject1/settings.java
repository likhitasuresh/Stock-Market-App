package com.example.likhitasuresh.miniproject1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class settings extends AppCompatActivity {
    String []options = {"Change Password"};
    ListView lv;
    EditText ab;
    SharedPreferences currpass;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ab = new EditText(this);
        ab.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Enter the new password").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String q = ab.getText().toString();
                currpass = getApplicationContext().getSharedPreferences("password",MODE_PRIVATE);
                SharedPreferences.Editor ed = currpass.edit();
                ed.putString("password",q);
                ed.apply();
                finish();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setView(ab);
        final AlertDialog alert = builder.create();

        ArrayAdapter adapter= new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,options){
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView)view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(18);
                return view;
            }
        };
        lv = (ListView) findViewById(R.id.lv3);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                          String s = (String) parent.getItemAtPosition(position);
                                          if(s.equals("Change Password"))
                                          {
                                           alert.show();
                                          }


                                      }
                                  }
        );

    }

}
