package com.example.lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtHoTen;
    TextView txtKetQua;
    Button butLuu;
    CheckBox boxC,boxJava,boxCJavaScirpt;
    RadioButton radDaihoc,radCaodang;
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
        addView();
        addEvent();

    }

    private void addEvent() {
        butLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten,he,monhoc;
                hoten=edtHoTen.getText().toString();
                he=radDaihoc.isChecked()?"Đại Học":radCaodang.isChecked()?"Cao Đăng":" Chưa Chọn";
                if (boxC.isChecked() && boxJava.isChecked() && boxCJavaScirpt.isChecked()) {
                    monhoc = "Lập Trình C, Java, JavaScript";
                } else if (boxC.isChecked() && boxJava.isChecked()) {
                    monhoc = "Lập Trình C, Java";
                } else if (boxC.isChecked() && boxCJavaScirpt.isChecked()) {
                    monhoc = "Lập Trình C, JavaScript";
                } else if (boxJava.isChecked() && boxCJavaScirpt.isChecked()) {
                    monhoc = "Java, JavaScript";
                } else {
                    monhoc = "Chưa Chọn môn học";
                }

                // Hiển thị kết quả
                txtKetQua.setText("Họ và Tên: " + hoten + "\nHệ: " + he + "\nMôn học yêu thích: " + monhoc);
            }
        });
    }

    private void addView() {
        edtHoTen=findViewById(R.id.edtHoTen);
        txtKetQua=findViewById(R.id.txtKetQua);
        butLuu=findViewById(R.id.butLuu);
        boxC=findViewById(R.id.boxC);
        boxJava=findViewById(R.id.boxJava);
        boxCJavaScirpt=findViewById(R.id.boxCJavaScirpt);
        radDaihoc=findViewById(R.id.radDaihoc);
       radCaodang=findViewById(R.id.radCaodang);
    }
}