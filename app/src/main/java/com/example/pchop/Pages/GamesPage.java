package com.example.pchop.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pchop.Data.DaftarGames;
import com.example.pchop.Data.DataGames;
import com.example.pchop.R;
import com.example.pchop.RVGamesAdapter;

import java.util.ArrayList;

public class GamesPage extends AppCompatActivity {
    ArrayList<DataGames> DataGamesList;

    private RecyclerView recyclerView;
    private RVGamesAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_page);

        DataGamesList = new DaftarGames().DataGames;

        recyclerView = findViewById(R.id.rv_games);
        recyclerViewAdapter = new RVGamesAdapter(this, DataGamesList);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}