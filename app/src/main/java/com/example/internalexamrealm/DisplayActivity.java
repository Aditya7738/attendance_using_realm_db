package com.example.internalexamrealm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class DisplayActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<DataModel> dataModelList;

    RecyclerViewAdapter recyclerViewAdapter;

    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        dataModelList = new ArrayList<>();

        realm = Realm.getDefaultInstance();

        recyclerView = (RecyclerView) findViewById(R.id.rv_list);

        dataModelList = realm.where(DataModel.class).findAll();

        recyclerViewAdapter = new RecyclerViewAdapter(dataModelList, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerViewAdapter);
    }
}