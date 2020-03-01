package com.example.userregestration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class usersAcivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context;
    private List<Users> user;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
         adapter = new RecyclerViewAdapter(user, context);
         recyclerView.setAdapter(adapter);

        initializedData();
    }


    public void initializedData() {
        user = new ArrayList<>();
        user= (List<Users>) new Users("Abdisa Idris","Abdisa2020");
        user= (List<Users>) new Users("Addis Ameru","Addisa7");

    }

}



