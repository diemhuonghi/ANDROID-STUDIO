package com.example.lab06;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.model.DanhMuc;
import com.example.model.SanPham;

public class MainActivity extends AppCompatActivity {
    Spinner spnDanhMuc;
    ArrayAdapter<DanhMuc> DanhMucAdapter;
    ArrayAdapter<SanPham> SanPhamAdapter;
    EditText editmaSP,edittenSp,editgiaSp;
    ListView lvSanpham;
    Button btnThem;
    DanhMuc selectedDanhMuc=null;
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
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyNhapSanPham();

                }

            private void XuLyNhapSanPham() {
                SanPham SanPham=new SanPham(editmaSP.getText().toString(),
                        edittenSp.getText().toString(),Integer.parseInt(editgiaSp.getText().toString()));
                     selectedDanhMuc.getSanPhams().add(SanPham);
                     SanPhamAdapter.add(SanPham);
            }

        });
        spnDanhMuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                selectedDanhMuc=DanhMucAdapter.getItem(i);
                SanPhamAdapter.clear();
                SanPhamAdapter.addAll(selectedDanhMuc.getSanPhams());
            }
        });
    }

    private void addView() {
        spnDanhMuc=findViewById(R.id.spnSanpham);
        DanhMucAdapter=new ArrayAdapter<DanhMuc>(MainActivity.this, android.R.layout.simple_spinner_item);
        spnDanhMuc.setAdapter(DanhMucAdapter);
        lvSanpham=findViewById(R.id.lvSanPham);
        SanPhamAdapter= new ArrayAdapter<SanPham>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvSanpham.setAdapter(SanPhamAdapter);
        editmaSP=findViewById(R.id.editmaSp);
        edittenSp=findViewById(R.id.editTenSp);
        editgiaSp=findViewById(R.id.editgiaSp);
        btnThem=findViewById(R.id.btnThem);
        DanhMucAdapter.add(new DanhMuc("1","Áo"));
        DanhMucAdapter.add(new DanhMuc("2","Quần"));
        DanhMucAdapter.add(new DanhMuc("3","Giày"));

    }
}