package com.example.simplesqlitess;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
}