package com.example.userregestration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    static  MyDatabase myDb;
    private static final String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.log_username);
        password=findViewById(R.id.password);
        //myDatabase= new MyDatabase(this);

    }

    //Login logic

    public void loginCheck(View view){

        String email= username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        Cursor c=MainActivity.myDb.userLoginCheck(email);
        c.moveToFirst();
        if (c==null){
            Toast.makeText(MainActivity.this,"Invalid credential for"+username,Toast.LENGTH_LONG).show();
           username.setText("");
           password.setText("");
        }else
        {
           String name2 =c.getString(0);
           String pass2=c.getString(1);

        }

        Intent intent=new Intent(MainActivity.this,usersAcivity.class);
        startActivity(intent);


    }

    //registration Logic
    public void registerCheck(View view){
        Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);

    }

}
