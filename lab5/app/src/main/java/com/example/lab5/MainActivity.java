package com.example.lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thành phần giao diện
    EditText etMaSo, etHoTen, etSoDienThoai;
    Button btnThemMoi;
    ListView lvNhanVien;

    ArrayList<String> danhSachNhanVien; // Danh sách nhân viên
    ArrayAdapter<String> adapter;      // Adapter cho ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        etMaSo = findViewById(R.id.etMaSo);
        etHoTen = findViewById(R.id.etHoTen);
        etSoDienThoai = findViewById(R.id.etSoDienThoai);
        btnThemMoi = findViewById(R.id.btnThemMoi);
        lvNhanVien = findViewById(R.id.lvNhanVien);

        // Tạo danh sách và adapter
        danhSachNhanVien = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, danhSachNhanVien);
        lvNhanVien.setAdapter(adapter);

        // Xử lý nút Thêm mới
        btnThemMoi.setOnClickListener(v -> {
            String maSo = etMaSo.getText().toString().trim();
            String hoTen = etHoTen.getText().toString().trim();
            String soDienThoai = etSoDienThoai.getText().toString().trim();

            // Kiểm tra thông tin hợp lệ
            if (maSo.isEmpty() || hoTen.isEmpty() || soDienThoai.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else {
                // Thêm nhân viên vào danh sách
                String nhanVien = maSo + " - " + hoTen + " - " + soDienThoai;
                danhSachNhanVien.add(nhanVien);
                adapter.notifyDataSetChanged();

                // Thông báo và xóa nội dung nhập
                Toast.makeText(MainActivity.this, "Thêm nhân viên thành công!", Toast.LENGTH_SHORT).show();
                etMaSo.setText("");
                etHoTen.setText("");
                etSoDienThoai.setText("");
            }
        });

        // Xử lý khi click vào nhân viên trong ListView
        lvNhanVien.setOnItemClickListener((parent, view, position, id) -> {
            String nhanVien = danhSachNhanVien.get(position);
            String[] parts = nhanVien.split(" - "); // Tách chuỗi thành các phần
            etMaSo.setText(parts[0]);
            etHoTen.setText(parts[1]);
            etSoDienThoai.setText(parts[2]);
        });

        // Xử lý khi long click để xóa nhân viên
        lvNhanVien.setOnItemLongClickListener((parent, view, position, id) -> {
            danhSachNhanVien.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Xóa nhân viên thành công!", Toast.LENGTH_SHORT).show();
            return true; // Đã xử lý long click
        });
    }
}
