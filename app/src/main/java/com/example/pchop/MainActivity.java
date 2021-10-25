package com.example.pchop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pchop.Model.User;
import com.example.pchop.Pages.ClothesPage;
import com.example.pchop.Pages.GamesPage;
import com.example.pchop.Pages.KitchenPage;
import com.example.pchop.Pages.SportPage;
import com.example.pchop.Preferences.UserPreferences;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private MaterialButton btnLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLocation = findViewById(R.id.btnLocation);

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LocationActivity.class));
                finish();
            }
        });
    }

    public View.OnClickListener btnHome = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SignActivity.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener btnClothes = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ClothesPage.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener btnKitchen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, KitchenPage.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener btnSport = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SportPage.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener btnGames = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, GamesPage.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.profileActivity){
            changeFragment(new ProfileFragment());
//        }else if(item.getItemId() == R.id.loginActivity){
//            changeFragment(new SignActivity());
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Yakin Keluar?")
                    .setPositiveButton("Y", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAndRemoveTask();
                        }
                    }).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.loginActivity, fragment)
                .commit();
    }
}