package com.myapp;

import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.myapp.adapter.PhongBanAdapter;

import java.util.ArrayList;

public class PhongBan extends AppCompatActivity {

    private ArrayList<model.PhongBan> listPB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);

        //ánh xạ
        ListView lvPhongBan = findViewById(R.id.lvPhongBan);

        //data

        //adapter
        PhongBanAdapter adapter = new PhongBanAdapter(PhongBan.this,getDSPB());
        lvPhongBan.setAdapter(adapter);
    }

    public ArrayList<model.PhongBan> getDSPB(){
        listPB = new ArrayList<>();
        listPB.add(new model.PhongBan("PB01", "Nhân sự"));
        listPB.add(new model.PhongBan("PB02", "Hành chính"));
        listPB.add(new model.PhongBan("PB03", "Đào tạo"));
        listPB.add(new model.PhongBan("PB04", "Tổng hợp"));
        return listPB;
    }
}