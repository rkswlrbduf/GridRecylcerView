package com.example.gridrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerVIewAdapter adapter;
    GridLayoutManager layoutManager;

    ArrayList<Item> list = new ArrayList<Item>() {{
        add(new Item("image1",R.drawable.image1));
        add(new Item("image2",R.drawable.image2));
        add(new Item("image3",R.drawable.image3));
        add(new Item("image4",R.drawable.image4));
        add(new Item("image5",R.drawable.image5));
        add(new Item("image6",R.drawable.image6));
        add(new Item("image7",R.drawable.image7));
        add(new Item("image8",R.drawable.image8));
        add(new Item("image9",R.drawable.image9));
        add(new Item("image10",R.drawable.image10));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.grid_recyclerview);
        adapter = new RecyclerVIewAdapter(getApplicationContext(), list);

        layoutManager = new GridLayoutManager(getApplicationContext(), 6);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int gridPosition = position % 5;
                switch (gridPosition) {
                    case 0:
                    case 1:
                    case 2:
                        return 2;
                    case 3:
                    case 4:
                        return 3;
                }
                return 0;
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
