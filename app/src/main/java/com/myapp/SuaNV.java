package com.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.myapp.adapter.SpinnerPhongBanAdapter;
import model.NhanSu;

import java.util.ArrayList;

public class SuaNV extends AppCompatActivity {
    private String tenpb="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_nv);

        EditText edtMaNV = findViewById(R.id.edtMaNV);
        EditText edtTenNV = findViewById(R.id.edtTenNV);
        Spinner spnTenPB = findViewById(R.id.spnTenPB);
        Button btnSuaNV = findViewById(R.id.btnSuaNV);
        Button btnTroVe = findViewById(R.id.btnTroVe);

        //set adapter cho spinner
        ArrayList<model.PhongBan> listPB = new PhongBan().getDSPB();
        SpinnerPhongBanAdapter adapter = new SpinnerPhongBanAdapter(SuaNV.this, listPB);
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

        //Nhận dữ liệu
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        model.NhanSu nhanVienSua = (model.NhanSu) bundle.getSerializable("nhanVienSua");
        int viTriSua = bundle.getInt("viTriSua");
        edtMaNV.setText(nhanVienSua.getManv());
        edtTenNV.setText(nhanVienSua.getTennv());

        int viTri = -1;
        for (int i = 0; i < listPB.size(); i++) {
            if (listPB.get(i).getTenpb().equals(nhanVienSua.getTenpb())) {
                viTri = i;
                break;
            }
        }
        spnTenPB.setSelection(viTri);

        btnSuaNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String manv = edtMaNV.getText().toString();
                String tennv = edtTenNV.getText().toString();

                model.NhanSu nhanVienSua = new NhanSu(manv, tennv, tenpb);
                Intent intentSua = new Intent();
                Bundle bundleSua = new Bundle();
                bundleSua.putSerializable("nhanVienSua", nhanVienSua);
                bundleSua.putInt("viTriSua",viTriSua);
                intentSua.putExtras(bundleSua);
                setResult(2,intentSua);
                finish();
            }
        });
    }
}