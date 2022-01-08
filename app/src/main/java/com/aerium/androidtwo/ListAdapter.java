package com.aerium.androidtwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<CustomList> arrayList;

    public ListAdapter(Context context, ArrayList<CustomList> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list,null);
            TextView tv =(TextView)view.findViewById(R.id.textView);

            CustomList list = arrayList.get(i);

            tv.setText(list.getFname() + " " + list.getLname() + "\n" + list.username + "\n" + list.getBranch() + "\n" + list.getCity());
        }
        return view;
    }
}
