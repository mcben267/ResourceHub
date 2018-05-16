package com.example.a16_0128.resourcehub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



public class RegistrationActivity extends AppCompatActivity {
    //firebase



    EditText name,email,major,password;
    Button signup;
    CheckBox agreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        signup = findViewById(R.id.btnSignup);
        name = findViewById(R.id.SignupName);
        email = findViewById(R.id.SignupEmail);
        major = findViewById(R.id.SignupMajor);
        password = findViewById(R.id.SignupPassword);
        agreement = findViewById(R.id.agreementid);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AddUser addUser= new AddUser(name.getText().toString(),
                       email.getText().toString(),
                       major.getText().toString(),
                       password.getText().toString());
            }
        });


    }

}
