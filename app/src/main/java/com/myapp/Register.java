package com.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Ánh xạ
        TextInputEditText edtUser = findViewById(R.id.edtUser);
        TextInputLayout txtUser = findViewById(R.id.txtUser);

        TextInputEditText edtPass = findViewById(R.id.edtPass);
        TextInputLayout txtPass = findViewById(R.id.txtPass);

        TextInputEditText edtRePass = findViewById(R.id.edtRePass);
        TextInputLayout txtRePass = findViewById(R.id.txtRePass);

        Button btnResgiter = findViewById(R.id.btnResgiter);
        Button btnBack = findViewById(R.id.btnBack);

        //Bắt sự kiện cho Resgister
        btnResgiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                String rePass = edtRePass.getText().toString();
                //Validate
                if (user.equals("") || pass.equals("") || rePass.equals("")) {
                    Toast.makeText(Register.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(rePass)) {
                    Toast.makeText(Register.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("user", user);
                    intent.putExtra("pass", pass);
                    setResult(1, intent);
                    finish();
                }
            }
        });

        }
    }