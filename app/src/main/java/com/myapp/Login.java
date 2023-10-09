package com.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    String userRegister ="";
    String passRegister = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Ánh xạ
        TextInputEditText edtUser = findViewById(R.id.edtUser);
        TextInputLayout txtUser = findViewById(R.id.txtUser);
        TextInputEditText edtPass = findViewById(R.id.edtPass);
        TextInputLayout txtPass = findViewById(R.id.txtPass);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        CheckBox chkRemember = findViewById(R.id.chkRemember);

        //Kiểm tra thông tin đăng nhập người dùng có lưu lại không??
        SharedPreferences sharedPreferences = getSharedPreferences("INFO",MODE_PRIVATE);
        boolean isRemember = sharedPreferences.getBoolean("isRemember",false);
        if(isRemember){
            String user = sharedPreferences.getString("userLogin","");
            String pass = sharedPreferences.getString("passLogin","");
            edtUser.setText(user);
            edtPass.setText(pass);
            chkRemember.setChecked(isRemember);
            userRegister = user;
            passRegister = pass;
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userLogin = edtUser.getText().toString();
                String passLogin = edtPass.getText().toString();
                if(userLogin.length() > 0 && passLogin.length() > 0 && userLogin.equals(userRegister) && passLogin.equals(passRegister)){
                    //check remember me
                    if(chkRemember.isChecked()){
                        SharedPreferences preferences = getSharedPreferences("INFO",MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("userLogin", userLogin);
                        editor.putString("passLogin", passLogin);
                        editor.putBoolean("isRemember",chkRemember.isChecked());
                        editor.apply();
                    }else {
                        SharedPreferences preferences = getSharedPreferences("INFO",MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.clear();
                        editor.apply();
                    }
                    Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                }else {
                    Toast.makeText(Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                myLauncher.launch(intent);
            }
        });
    }

    private ActivityResultLauncher<Intent> myLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            //Nơi xử lý dữ liệu trả về regitster
                            if (result.getResultCode() == 1) {
                                Intent intent = result.getData();
                                userRegister = intent.getStringExtra("user");
                                passRegister = intent.getStringExtra("pass");
                            }
                        }
                    });

}