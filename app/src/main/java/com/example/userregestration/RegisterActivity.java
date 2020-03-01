package com.example.userregestration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText editFullName, editUserName, editEmail, editPassword, editPhoneNumber, editGender;
    Button button_register;
    static MyDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor);
        editFullName = findViewById(R.id.fulName);
        editUserName = findViewById(R.id.userName);
        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
        editPhoneNumber = findViewById(R.id.phone);
        editGender = findViewById(R.id.gender);
        button_register = findViewById(R.id.register_users);
        AddData();
    }

    public void AddData() {
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String full_name = editFullName.getText().toString();
                String user_name = editUserName.getText().toString();
                String password = editPassword.getText().toString();
                String email = editEmail.getText().toString();
                String phone_number = editPhoneNumber.getText().toString();
                String gender = editGender.getText().toString();

                if (TextUtils.isEmpty(full_name)) {
                    Toast.makeText(RegisterActivity.this, "please inter full name", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(user_name)) {
                    Toast.makeText(RegisterActivity.this, "please insert user name", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "please insert password", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(RegisterActivity.this, "please insert email", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(gender)) {
                    Toast.makeText(RegisterActivity.this, "please insert gender", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(phone_number)) {
                    Toast.makeText(RegisterActivity.this, "please insert phone number", Toast.LENGTH_LONG).show();
                    return;
                }

                boolean isInserted;
                if (myDb.insertData(full_name, user_name, password, email, gender, phone_number))
                    isInserted = true;
                else isInserted = false;
                if (isInserted == true) {
                    Toast.makeText(RegisterActivity.this, "Data successfully inserted", Toast.LENGTH_LONG).show();
                    editFullName.setText("");
                    editUserName.setText("");
                    editPassword.setText("");
                    editEmail.setText("");
                    editGender.setText("");
                    editPhoneNumber.setText("");
                } else
                    Toast.makeText(RegisterActivity.this, "data not inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

}
