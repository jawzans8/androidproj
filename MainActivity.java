package com.example.myappjoz;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txreg;
    EditText Password;
    EditText Emil;
    Button enter;
    static String user, pa;
 db dbHandler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txreg = (TextView) findViewById(R.id.reg);
        Password = (EditText) findViewById(R.id.pass);
        Emil = (EditText) findViewById(R.id.email);
        enter = (Button) findViewById(R.id.log);



        dbHandler = new db(this);

        txreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), newreg.class);//go anthoer activity
                startActivity(it);
                fileList();
            }
        });
    }

    public void log(View V) {
        EditText usr = (EditText) findViewById(R.id.email);
        EditText PassInput = (EditText) findViewById(R.id.pass);
        user = usr.getText().toString();
        pa = PassInput.getText().toString();

        dbHandler.addRecord(user ,pa);

        SharedPreferences userAccounts = getSharedPreferences(" UserAccounts", 0);
        if (!userAccounts.contains(user)) {
            Toast.makeText(getApplicationContext(), "  The user account is not existent", Toast.LENGTH_LONG).show();
            return;
        }

        if ((userAccounts.getString(user, null)).equals(pa)) {
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
            enter = (Button) findViewById(R.id.log);;
            Intent Int = new Intent(getApplicationContext(), loginj.class);
            startActivity(Int);
            finish();
        } else
            Toast.makeText(getApplicationContext(), "  The password entered is wrong", Toast.LENGTH_LONG).show();
    }


}
