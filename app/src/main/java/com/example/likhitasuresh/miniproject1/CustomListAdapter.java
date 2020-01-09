package com.example.likhitasuresh.miniproject1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<CompanyItem> listData;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context aContext, ArrayList<CompanyItem> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list2, null);
            holder = new ViewHolder();
            holder.NameView = (TextView) convertView.findViewById(R.id.Name);
            holder.Name2View = (TextView) convertView.findViewById(R.id.Name2);
            holder.PriceView = (TextView) convertView.findViewById(R.id.Price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.NameView.setText(listData.get(position).getName());
        holder.Name2View.setText(listData.get(position).getName2());
        holder.PriceView.setText(listData.get(position).getPrice());
        holder.NameView.setTextColor(Color.WHITE);
        holder.Name2View.setTextColor(Color.WHITE);
        holder.PriceView.setTextColor(Color.WHITE);

        return convertView;
    }

    static class ViewHolder {
        TextView NameView;
        TextView Name2View;
        TextView PriceView;
    }
}
