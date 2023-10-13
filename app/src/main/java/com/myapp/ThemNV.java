package com.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.myapp.adapter.SpinnerPhongBanAdapter;
import model.NhanSu;

import java.util.ArrayList;

public class ThemNV extends AppCompatActivity {

    private String tenpb="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);

        EditText edtMaNV = findViewById(R.id.edtMaNV);
        EditText edtTenNV = findViewById(R.id.edtTenNV);
        Spinner spnTenPB = findViewById(R.id.spnTenPB);
        Button btnThemNV = findViewById(R.id.btnThemNV);
        Button btnTroVe = findViewById(R.id.btnTroVe);

        //set adapter cho spinner
        ArrayList<model.PhongBan> listPB = new PhongBan().getDSPB();
        SpinnerPhongBanAdapter adapter = new SpinnerPhongBanAdapter(ThemNV.this,listPB);
        spnTenPB.setAdapter(adapter);

        //Lấy dữ liệu spinner
        spnTenPB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tenpb = listPB.get(i).getTenpb();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Thêm nhân viên
        btnThemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String manv = edtMaNV.getText().toString();
                String tennv = edtTenNV.getText().toString();

                model.NhanSu nhanVienMoi = new NhanSu(manv, tennv, tenpb);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("nhanVienMoi", nhanVienMoi);
                intent.putExtras(bundle);
                setResult(1,intent);
                finish();
            }
        });
    }
}