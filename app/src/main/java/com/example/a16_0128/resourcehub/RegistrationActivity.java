package com.example.a16_0128.resourcehub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        FirebaseDatabase database =FirebaseDatabase.getInstance();
        final DatabaseReference users = database.getReference("User");


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AddUser addUser= new AddUser(name.getText().toString(),
                       email.getText().toString(),
                       major.getText().toString(),
                       password.getText().toString());

                users.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       if(dataSnapshot.child(addUser.getEmail()).exists()){
                           Toast.makeText(RegistrationActivity.this,"User Already exist",Toast.LENGTH_SHORT).show();
                       }
                       else{
                           users.child(addUser.getEmail()).setValue(addUser);
                           Toast.makeText(RegistrationActivity.this,"Successful Registration",Toast.LENGTH_SHORT).show();
                       }
                   }

                   @Override
                   public void onCancelled(DatabaseError databaseError) {

                   }
               });
            }
        });


    }

}
