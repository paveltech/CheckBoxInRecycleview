package com.playoffstudio.checkboxinrecycleview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycleview_item)
    RecyclerView recyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    public MyAdapter adapter;

    public ArrayList<MyPojo> myPojoArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        myPojoArrayList = new ArrayList<>();
        myPojoArrayList.add(new MyPojo(101 , true , "pavel"));
        myPojoArrayList.add(new MyPojo(102 , true , "robin"));
        myPojoArrayList.add(new MyPojo(103 , true , "nisan"));
        myPojoArrayList.add(new MyPojo(104 , false , "jwel"));
        myPojoArrayList.add(new MyPojo(105 , false , "lia"));
        myPojoArrayList.add(new MyPojo(106 , false , "labisa"));
        myPojoArrayList.add(new MyPojo(107 , false , "rabib"));
        myPojoArrayList.add(new MyPojo(108 , false , "nojrul"));

        adapter = new MyAdapter(getApplicationContext() , myPojoArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DATA_SELECT" , ""+adapter.getItemPositions());
            }
        });
    }

}
