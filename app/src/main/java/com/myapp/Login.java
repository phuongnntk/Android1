package com.myapp;

import android.content.Intent;
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
                            if (result.getResultCode() == 1){
                                Intent intent = result.getData();
                                String user = intent.getStringExtra("user");
                                String pass = intent.getStringExtra("pass");
                                Toast.makeText(Login.this, user+"-" +pass, Toast.LENGTH_SHORT).show();
                            }
                        }
            });
}