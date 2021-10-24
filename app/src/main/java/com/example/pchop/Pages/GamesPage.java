package com.example.pchop.Pages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pchop.R;

public class GamesPage extends AppCompatActivity {

    public DosenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Data Dosen");

        // Menghubungkan rvDosen dengan recycler view yang ada pada layout
        RecyclerView rvDosen = view.findViewById(R.id.rv_dosen);

        //  Set Layout Manager dari recycler view
        rvDosen.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));

        //  Set Adapter dari recycler view.
        rvDosen.setAdapter(new RVDosenAdapter(Dosen.listOfDosen));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_games_page, container, false);
    }
}