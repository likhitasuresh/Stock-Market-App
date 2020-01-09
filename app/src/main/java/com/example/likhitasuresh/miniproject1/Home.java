package com.example.likhitasuresh.miniproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView name, price, change, Change, change2, Change2, name2;
    Bundle b, b2;
    String k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name = (TextView) findViewById(R.id.Name1);
        registerForContextMenu(name);
        name2 = (TextView) findViewById(R.id.Name21);
        price = (TextView) findViewById(R.id.Price1);
        change = (TextView) findViewById(R.id.change1);
        Change = (TextView) findViewById(R.id.Change1);
        Change2 = (TextView) findViewById(R.id.Change21);
        change2 = (TextView) findViewById(R.id.change21);
        Bundle b = this.getIntent().getExtras();
        k = b.getString("Name");
        name.setText(k);
        // registerForContextMenu(name);
        name2.setText(b.getString("Name2"));
        price.setText("Price: " + b.getString("Price"));
        String j = b.getString("Change");
        String k = b.getString("Change2");
        if (j.contains("+"))
            Change.setText("Change: " + b.getString("Change"));
        else if (j.contains("-"))
            change.setText("Change: " + b.getString("Change"));
        if (j.contains("+"))
            Change2.setText("After: " + b.getString("Change2"));
        else if (j.contains("-"))
            change2.setText("After: " + b.getString("Change2"));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    android.view.ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (k.equals("Dow Jones International")) {
            switch (item.getItemId()) {
                case R.id.about:

                    Intent i = new Intent(getApplicationContext(), info.class);
                    b2 = new Bundle();
                    b2.putString("name", k);
                    i.putExtras(b2);
                    startActivity(i);
                    return true;
                case R.id.growth:
                   Toast.makeText(getApplicationContext(),"Currently unavailable",Toast.LENGTH_LONG).show();
                    return true;

            }
        }

            switch (item.getItemId()) {
                case R.id.about:

                    Intent i = new Intent(getApplicationContext(), info.class);
                    b2 = new Bundle();
                    b2.putString("name", k);
                    i.putExtras(b2);
                    startActivity(i);
                    return true;
                case R.id.growth:

                    Intent i2 = new Intent(getApplicationContext(), Trial.class);
                    b2 = new Bundle();
                    b2.putString("name", k);
                    i2.putExtras(b2);
                    startActivity(i2);
                    return true;
                default:
                    return super.onContextItemSelected(item);
            }
        }

}

