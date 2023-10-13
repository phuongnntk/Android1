package com.myapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.myapp.R;
import model.PhongBan;

import java.util.ArrayList;

public class SpinnerPhongBanAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<PhongBan> listPB;

    public SpinnerPhongBanAdapter(Context context, ArrayList<PhongBan> listPB) {
        this.context = context;
        this.listPB = listPB;
    }

    @Override
    public int getCount() {
        return listPB.size();
    }

    @Override
    public Object getItem(int i) {
        return listPB.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View  view = inflater.inflate(android.R.layout.simple_list_item_1,viewGroup,false);
        TextView txtTenPB = view.findViewById(android.R.id.text1);
        txtTenPB.setText(listPB.get(i).getTenpb());
        return view;
    }
}
