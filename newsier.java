package com.example.myappjoz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class newreg extends AppCompatActivity {
    SharedPreferences usrAccs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newreg);
    }

    public void signUp(View V){
        EditText usrs=(EditText)findViewById(R.id.usrInp);
        EditText pwd=(EditText)findViewById(R.id.pwdInp);

        usrAccs= getApplicationContext().getSharedPreferences(" UserAccounts",0);
        SharedPreferences.Editor usrAccsEditor=usrAccs.edit();

        if(usrAccs.contains(usrs.getText().toString())){
            Toast.makeText(getApplicationContext()," The user account is already existent",
                    Toast.LENGTH_LONG).show();
            return; }

        usrAccsEditor.putString(usrs.getText().toString(),pwd.getText().toString());
        usrAccsEditor.commit();


        Toast.makeText(getApplicationContext(),usrs.getText().toString()+
                "  .. account is created",Toast.LENGTH_LONG).show();


        Intent Int=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(Int);
        finish();
    }
}
