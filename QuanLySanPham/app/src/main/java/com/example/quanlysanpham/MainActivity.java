package com.example.quanlysanpham;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quanlysanpham.SanPham;

public class MainActivity extends AppCompatActivity {
    ListView lvSanPham;
    ArrayAdapter<SanPham> sanPhamAdapter;
    Button btnxoa , btnback;


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
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = sanPhamAdapter.getItem(position);
                Intent intent = new Intent(MainActivity.this , ChiTietActivity.class);
                intent.putExtra("SANPHAM", (CharSequence) sp);
                startActivityForResult(intent,113);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void addView() {
        lvSanPham=findViewById(R.id.lvSanPham);
        sanPhamAdapter= new ArrayAdapter<SanPham>(MainActivity.this , android.R.layout.simple_list_item_1);
        lvSanPham.setAdapter(sanPhamAdapter);
        sanPhamAdapter.add(new SanPham(100000,"001","Quần Jean Rách Gối"));
        sanPhamAdapter.add(new SanPham(200000,"002","Áo Thun DIOR"));
        sanPhamAdapter.add(new SanPham(150000,"003","Quần Đùi BlackPink"));
        sanPhamAdapter.add(new SanPham(13000000,"004","Nguyễn Ngọc Vỹ"));
    }
}