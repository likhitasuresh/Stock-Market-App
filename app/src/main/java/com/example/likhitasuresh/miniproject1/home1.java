package com.example.likhitasuresh.miniproject1;


import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class home1 extends AppCompatActivity {
    String s, s2, s3;
    TextView tv1;
    CompanyItem companyData;
    CustomListAdapter adapter;

    List<String> companies, name2, price;

    ArrayList image_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);


            final ListView lv1 = (ListView) findViewById(R.id.custom_list);
            ArrayList<CompanyItem>results = new ArrayList<CompanyItem>();
            final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
            databaseAccess.open();
             companies = databaseAccess.getName();
             name2 = databaseAccess.getName2();
             price = databaseAccess.getPrice();
             databaseAccess.close();
             image_details = getListData();

            adapter = new CustomListAdapter(getApplicationContext(), image_details);
            lv1.setAdapter(adapter);
             lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                CompanyItem companyData = (CompanyItem) o;
                Intent i = new Intent(getApplicationContext(), Home.class);
                Bundle b = new Bundle();
                b.putString("Name",companyData.Name);
                b.putString("Name2",companyData.Name2);
                b.putString("Price",companyData.Price);
                databaseAccess.open();
                String x,x1;
                x=databaseAccess.getChange(companyData.Name);
                x1=databaseAccess.getChange2(companyData.Name);
                 b.putString("Change",x);
                b.putString("Change2",x1);
                databaseAccess.close();
                i.putExtras(b);
                startActivity(i);

            }
        });

    }
    private ArrayList getListData() {
        ArrayList<CompanyItem> results = new ArrayList<>();
        int i=0; String s, s2, s3;
       for(i=2;i<companies.size();i++) {
           companyData = new CompanyItem();
           s=companies.get(i);
           companyData.setName(s);
           s2 = companies.get(i);
           companyData.setName2(s2);
           s3 = price.get(i);
           companyData.setPrice(s3);
           results.add(companyData);
       }
       return results;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menux, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                Intent i = new Intent(getApplicationContext(),settings.class);
                startActivity(i);
                return true;

            case R.id.item3:
                Intent i3 = new Intent(getApplicationContext(),about.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
