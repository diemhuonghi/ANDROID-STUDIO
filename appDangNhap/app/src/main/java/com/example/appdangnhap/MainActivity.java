package com.example.appdangnhap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText tendangnhap,matkhau;
    Button dangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getView();
        getEven();
    }



    private void getEven() {
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tendn=tendangnhap.getText().toString();
                String mk=matkhau.getText().toString();
                Toast.makeText(MainActivity.this,tendn+" -  " +mk,Toast.LENGTH_LONG).show();
                if(tendn.trim().equals("CNTT") && matkhau.equals("123456")){
                    Toast.makeText(MainActivity.this,"dang nhap thanh cong",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"dang nhap that bai",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void getView() {
        tendangnhap=findViewById(R.id.edtTenDN);
        matkhau=findViewById(R.id.edtMatKhau);
        dangnhap=findViewById(R.id.btnDangnhap);
    }

}