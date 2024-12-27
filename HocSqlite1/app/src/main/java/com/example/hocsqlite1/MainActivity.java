package com.example.hocsqlite1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    String dbName = "Contact DB.db";
    String dbPath = "/databases/";
    SQLiteDatabase db = null;
    ArrayAdapter<Contact> adapter;
    ListView lvContact;

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
        xuLycopy();
        addView();
        hienthiContact();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context, menu);
    }

    private void hienthiContact() {
        db=openOrCreateDatabase(dbName,MODE_PRIVATE,null);
        Cursor cursor=db.rawQuery("Select * from Contact",null);
        while(cursor.moveToNext())
        {
            int ma=cursor.getInt(0);
            String ten=cursor.getString(1);
            String dienthoai=cursor.getString(2);
            adapter.add(new Contact(ma,ten,dienthoai));
        }
    }

    private void addView() {
        lvContact=findViewById(R.id.lvContact);
        adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvContact.setAdapter(adapter);
        registerForContextMenu(lvContact);

    }

    private void xuLycopy(){
        try{
            File dbFile=getDatabasePath(dbName);
            //TextView txtText=findViewById(R.id.txtText);
            if(!dbFile.exists())
            {
                copyDataFromAsset();
                Toast.makeText(MainActivity.this,"Copy thành công",Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(MainActivity.this
                        ,"file đã tồn tại trên app",
                        Toast.LENGTH_LONG).show();
        }
        catch(Exception e){
            Log.e("Loi",e.toString());
        }
    }

    private void copyDataFromAsset() {
        try {
            InputStream myInput = getAssets().open(dbName);
            String outFileName = getApplicationInfo().dataDir + dbPath + dbName;
            File f = new File(getApplicationInfo().dataDir + dbPath);
            if (!f.exists())
                f.mkdir();
            OutputStream myOutput = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (Exception ex) {
            Log.e("LOI", ex.toString());
        }
    }
}