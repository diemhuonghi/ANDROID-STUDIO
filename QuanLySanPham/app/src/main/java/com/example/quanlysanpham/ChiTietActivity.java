package com.example.quanlysanpham;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quanlysanpham.SanPham;

public class ChiTietActivity extends AppCompatActivity {
    EditText editmasp, edittensp, editgiasp;
    Button btnxoa, btnback;
    Intent intent;
    SanPham sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addView();
        addEvent();

    }

    private void addEvent() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("SANPHAM" , sp);
                setResult(115,intent);
                finish();
            }
        });
    }

    private void addView() {
        editmasp=findViewById(R.id.editmasp);
        edittensp=findViewById(R.id.edittensp);
        editgiasp=findViewById(R.id.editgiasp);
        btnxoa=findViewById(R.id.btnxoa);
        btnback=findViewById(R.id.btnback);
        intent=getIntent();
        sp =(SanPham) intent.getSerializableExtra("SANPHAM");
        editmasp.setText(sp.getMa());
        edittensp.setText(sp.getTen());
        editgiasp.setText(sp.getGia()+"");

    }
}