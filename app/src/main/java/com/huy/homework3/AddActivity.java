package com.huy.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.huy.homework3.data.AppDatabase;
import com.huy.homework3.data.User;

public class AddActivity extends AppCompatActivity {
    private EditText edtName,edtNumber;
    private Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edtName= findViewById(R.id.edtName);
        edtNumber= findViewById(R.id.edtNumber);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(view -> {
            db.userDao().insertAll(new User(edtName.getText().toString(), edtNumber.getText().toString()));
            startActivity(new Intent(AddActivity.this, MainActivity.class));
        });
    }
}
