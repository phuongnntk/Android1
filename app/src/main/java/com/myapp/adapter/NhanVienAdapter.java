package com.myapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import com.myapp.R;
import com.myapp.SuaNV;
import model.NhanSu;
import model.PhongBan;

import java.util.ArrayList;

public class NhanVienAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NhanSu> listNV;

    private ActivityResultLauncher<Intent> myLauncher;

    public NhanVienAdapter(Context context, ArrayList<NhanSu> listNV, ActivityResultLauncher<Intent> myLauncher) {
        this.context = context;
        this.listNV = listNV;
        this.myLauncher = myLauncher;
    }

    @Override
    public int getCount() {
        return listNV.size();
    }

    @Override
    public Object getItem(int i) {
        return listNV.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View  view = inflater.inflate(R.layout.item_nhan_su, viewGroup,false);
        TextView txtMaNV = view.findViewById(R.id.txtMaNV);
        TextView txtTenNV = view.findViewById(R.id.txtTenNV);
        TextView txtTenPB = view.findViewById(R.id.txtTenPB);
        ImageView ivEdit = view.findViewById(R.id.ivEdit);
        ImageView ivDel = view.findViewById(R.id.ivDel);

        txtMaNV.setText(listNV.get(i).getManv());
        txtTenNV.setText(listNV.get(i).getTennv());
        txtTenPB.setText(listNV.get(i).getTenpb());

        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SuaNV.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("nhanVienSua",listNV.get(i));
                bundle.putInt("viTriSua", i);
                intent.putExtras(bundle);
                myLauncher.launch(intent);
            }
        });
        ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listNV.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
