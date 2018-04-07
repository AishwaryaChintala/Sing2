package com.example.rnikhithareddy.sing2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button register;
    private EditText semail;
    private EditText spass;
    private EditText sname;
    private Button adduser;
    Button dl;
    private FirebaseAuth firebaseAuth;
    //private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        semail = (EditText) findViewById(R.id.emailedit);
        spass = (EditText) findViewById(R.id.passedit);
        sname = (EditText) findViewById(R.id.nameeedit);

        firebaseAuth = FirebaseAuth.getInstance();
        //  databaseReference=FirebaseDatabase.getInstance().getReference();

        register = (Button) findViewById(R.id.btnreg);
        dl=(Button)findViewById(R.id.btnl);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "Please wait...", "on process..", true);
                (firebaseAuth.createUserWithEmailAndPassword(semail.getText().toString(), spass.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Sign in Successfull", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity.this, Login.class);
                            startActivity(i);
                        } else {
                            Log.e("error..", task.getException().toString());
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }

        });
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });

        /*adduser=(Button)findViewById(R.id.addbtn);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=sname.getText().toString().trim();
                String email=semail.getText().toString().trim();


                HashMap<String,String> datamap=new HashMap<String, String>();
                datamap.put("Name",name);
                datamap.put("Email",email);


                databaseReference.push().setValue(datamap);
                Toast.makeText(SignupActivity.this,"added user",Toast.LENGTH_LONG).show();


            }
        });*/

    }
}