package com.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.myapp.adapter.NhanVienAdapter;

import java.util.ArrayList;

public class NhanSu extends AppCompatActivity {
    private ArrayList<model.NhanSu> listNV;
    private ListView lvNhanSu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_su);

        lvNhanSu = findViewById(R.id.lvNhanSu);
        Button btnThemNV = findViewById(R.id.btnThemNV);

        listNV = new ArrayList<>();
        listNV.add(new model.NhanSu("NV01","Kim Phượng", "Nhân sự"));
        listNV.add(new model.NhanSu("NV02","Thanh Trúc", "Hành chính"));
        listNV.add(new model.NhanSu("NV03","Long Vân", "Tổng hợp"));
        listNV.add(new model.NhanSu("NV04","Gia Bảo", "Đào tạo"));
        loadData();

        btnThemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NhanSu.this, ThemNV.class);
                myLauncher.launch(intent);
            }
        });
    }

    private void loadData(){
        NhanVienAdapter adapter = new NhanVienAdapter(NhanSu.this,listNV,myLauncher);
        lvNhanSu.setAdapter(adapter);
    }

    private ActivityResultLauncher<Intent> myLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                //Thêm trả về
                    if(result.getResultCode() == 1){
                        Intent intent = result.getData();
                        Bundle bundle = intent.getExtras();
                        model.NhanSu nhanVienMoi = (model.NhanSu) bundle.getSerializable("nhanVienMoi");
                        listNV.add(nhanVienMoi);
                        loadData();
                    }
                    if (result.getResultCode() == 2){
                        Intent intent = result.getData();
                        Bundle bundle = intent.getExtras();
                        model.NhanSu nhanVienSua = (model.NhanSu) bundle.getSerializable("nhanVienSua");
                        int viTriSua = bundle.getInt("viTriSua");
                        listNV.set(viTriSua, nhanVienSua);
                        loadData();
                    }
                }
            });
}