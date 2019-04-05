package com.example.myappjoz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static com.example.myappjoz.MainActivity.user;
public class loginj extends AppCompatActivity {

    SharedPreferences usrAccs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginj);
    }


    public void inter(View V) {

        Intent Int = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(Int);
        finish();
    }
}
