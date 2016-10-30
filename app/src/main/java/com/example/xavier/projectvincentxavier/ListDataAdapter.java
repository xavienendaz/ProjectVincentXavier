package com.example.xavier.projectvincentxavier;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xavier on 30.10.2016.
 */

public class ListDataAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView USERNAME, PASSWORD;
    }


    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;

        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.USERNAME = (TextView)row.findViewById(R.id.text_username );
            layoutHandler.PASSWORD = (TextView)row.findViewById(R.id.text_password);
            row.setTag(layoutHandler);
        }
        else{
            //if the row is already existing
            layoutHandler = (LayoutHandler)row.getTag();

        }

        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layoutHandler.USERNAME.setText(dataProvider.getUsername());
        layoutHandler.PASSWORD.setText(dataProvider.getPassword());

        return row;
    }
}
