package com.huy.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.huy.homework3.data.AppDatabase;
import com.huy.homework3.data.User;
import com.huy.homework3.data.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvUser;
    private UserAdapter user_adapter;
    private TextView tvName, tvNumber;
    private Button btnAdd;
//    List<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvUser = findViewById(R.id.rcv_user);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

//        user_adapter.setData(list);

//        for (int i =0;i<10;i++){
//            list.add(new User("A","B"+i));
//        }
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();

        List<User> list = db.userDao().getAll();
        user_adapter = new UserAdapter(list);
        rcvUser.setAdapter(user_adapter);

        tvName = findViewById(R.id.tv_name);
        tvNumber = findViewById(R.id.tv_number);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });

    }
}