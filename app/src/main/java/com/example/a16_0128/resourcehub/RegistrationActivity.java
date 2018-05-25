package com.example.a16_0128.resourcehub;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONObject;

import static android.text.TextUtils.isEmpty;


public class RegistrationActivity extends AppCompatActivity {
    //firebase
    private FirebaseAuth mAuth;

    //http
    JSONObject json_data;
    HttpURLConnection con;
    String query,results;
    ProgressDialog mProgressDialog;

    EditText name,email,major,password;
    Button signup;
    CheckBox agreement;

    String nameInput,emailInput,majorInput,passwordInput;

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



        // Reset errors.
        name.setError(null);
        email.setError(null);
        major.setError(null);
        password.setError(null);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(nameInput)){
                    name.setError(getString(R.string.error_field_required));
                }
                else if (!TextUtils.isEmpty(emailInput)){
                    email.setError(getString(R.string.error_field_required));
                }
                else if (!TextUtils.isEmpty(majorInput)){
                    major.setError(getString(R.string.error_field_required));
                }
                else if (!TextUtils.isEmpty(passwordInput)){
                    password.setError(getString(R.string.error_field_required));
                }
                else if (!agreement.isChecked()){
                    agreement.setError(getString(R.string.accept_tnc));
                }else {
                new Create().execute();}
            }
        });


    }
    final class Create extends AsyncTask<String, Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(RegistrationActivity.this);
            mProgressDialog.setMessage("Creating record please wait..");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }
        @Override
        protected Void doInBackground(String... params) {
            try {
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("name", name.getText().toString().trim())
                        .appendQueryParameter("email", email.getText().toString().trim())
                        .appendQueryParameter("major", major.getText().toString().trim())
                        .appendQueryParameter("password", password.getText().toString().trim());
                query = builder.build().getEncodedQuery();
                String url = "https://mcben267.000webhostapp.com/mcbenapp/newuser.php";
                URL obj = new URL(url);
                con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
                con.setRequestProperty("Accept-Language", "UTF-8");
                con.setDoOutput(true);
                OutputStreamWriter outputStreamWriter = new
                        OutputStreamWriter(con.getOutputStream());
                outputStreamWriter.write(query);
                outputStreamWriter.flush();
            } catch (Exception e) {
                android.util.Log.e("Fail 1", e.toString());
            }
            try {
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(con.getInputStream()));
                String line;
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line + "\n");
                }
                results = sb.toString();
            } catch (Exception e) {
                android.util.Log.e("Fail 2", e.toString());}
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            try {
                json_data = new JSONObject(results);
                int code = (json_data.getInt("code"));
                if (code == 1) {
                    final AlertDialog.Builder alert = new AlertDialog.Builder(RegistrationActivity.this);
                    alert.setTitle("Success");
                    alert.setMessage("Student Record Created");
                    alert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(@NonNull DialogInterface dialog, int whichButton) {
                            dialog.cancel();
                        }
                    });
                    alert.show();
                } else {
                    final AlertDialog.Builder alert = new AlertDialog.Builder(RegistrationActivity.this);
                    alert.setTitle("Failed");
                    alert.setMessage("Creating Student Failed");
                    alert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(@NonNull DialogInterface dialog, int whichButton) {
                            dialog.cancel();
                        }
                    });
                    alert.show();
                }
            } catch (Exception e) {
                Log.e("Fail 3", e.toString());
            }mProgressDialog.dismiss();
        }
    }



}
