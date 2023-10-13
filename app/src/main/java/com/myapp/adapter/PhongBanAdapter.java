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

public class PhongBanAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<PhongBan> listPB;

    public PhongBanAdapter(Context context, ArrayList<PhongBan> listPB) {
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
        View  view = inflater.inflate(R.layout.item_phong_ban, viewGroup,false);
        TextView txtTenPB = view.findViewById(R.id.txtTenPB);
        String data = listPB.get(i).getMapb() + " - "+listPB.get(i).getTenpb();
        txtTenPB.setText(data);
        return view;
    }
}
