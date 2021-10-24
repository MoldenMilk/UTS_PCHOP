package com.example.pchop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pchop.Database.DatabaseClient;
import com.example.pchop.Model.User;
import com.example.pchop.Preferences.UserPreferences;
import com.google.android.material.button.MaterialButton;
import com.example.pchop.R;

public class SignActivity extends AppCompatActivity {
    private EditText etEmail, etUsername, etPassword;
    private MaterialButton btnSignup;
    private UserPreferences userPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        userPreferences = new UserPreferences(SignActivity.this);

        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateForm()){
                    register(etEmail.getText().toString(), etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
                }
            }
        });
    }

    private void register(String email,String username, String password){

        class RegisterUser extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User();
                user.setEmail(email);
                user.setUsername(username);
                user.setPassword(password);

                DatabaseClient.getInstance(SignActivity.this)
                        .getDatabase()
                        .userDao()
                        .registerUser(user);

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Toast.makeText(SignActivity.this, "Berhasil mendaftar", Toast.LENGTH_SHORT).show();
                clearField();
                startActivity(new Intent(SignActivity.this, LoginActivity.class));
                finish();
            }

        }

        RegisterUser registerUser = new RegisterUser();
        registerUser.execute();
    }

    private void clearField(){
        etEmail.setText("");
        etUsername.setText("");
        etPassword.setText("");
    }


    private boolean validateForm(){
        /* Check username & password is empty or not */
        if(etUsername.getText().toString().trim().isEmpty() || etPassword.getText().toString().trim().isEmpty() || etEmail.getText().toString().trim().isEmpty()){
            Toast.makeText(SignActivity.this,"Field tidak boleh Kosong",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}