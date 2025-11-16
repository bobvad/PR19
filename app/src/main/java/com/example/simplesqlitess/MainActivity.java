package com.example.simplesqlitess;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText EtName, EtMail;
    TextView tvContent;
    DbHelper DbHelper;
    SQLiteDatabase DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EtName = findViewById(R.id.etName);
        EtMail = findViewById(R.id.etMail);
        tvContent = findViewById(R.id.tvContent);
        
        DbHelper = new DbHelper(this);
        DB = DbHelper.getWritableDatabase();
    }
    public void onAdd(View view)
    {
        ContentValues CV = new ContentValues();
        CV.put("Name",EtName.getText().toString());
        CV.put("Mail",EtMail.getText().toString());
        DB.insert("Users",null, CV);
    }
    public void onRead(View view)
    {
        String Data = "";

        Cursor C = DB.query("Users",null,null,null,null,null, null);
        if(C.moveToFirst())
        {
            do {
                Data += "Id=" + C.getInt(0) + ", Name=" + C.getString(1) + ", Mail=" + C.getString(2) + "\r\n";
            } while (C.moveToNext());
        }
        C.close();
        tvContent.setText(Data);
    }
    public  void  OnDelete(View view)
    {
        DB.delete("Users",null,null);
    }
}