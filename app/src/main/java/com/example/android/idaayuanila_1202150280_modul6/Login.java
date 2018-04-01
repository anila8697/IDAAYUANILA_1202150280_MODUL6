package com.example.android.idaayuanila_1202150280_modul6;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

        private EditText mEmail;
        private EditText mPass;
        private Button mRegister;
        private Button mLogin;
        private FirebaseAuth mAuth;

        private String TAG = "com.example.android.idaayuanila_1202150280_modul6";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //inisialisasi firebase
        mAuth = FirebaseAuth.getInstance();
        //inisialisasi
        mEmail=(EditText)findViewById(R.id.email);
        mPass=(EditText)findViewById(R.id.editpass);
        mLogin=(Button)findViewById(R.id.button3);
        mRegister=(Button)findViewById(R.id.button2);

    }

    public void Register(View view) {
        String email=mEmail.getText().toString();
        String pass=mPass.getText().toString();



        //jika field nya tidak terisi maka akan muncul toast
        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(pass)) {
            Toast.makeText(Login.this, "Doesn't allow empty", Toast.LENGTH_LONG).show();

            //untuk membuat register melalui email dan password
        }else {
            mAuth.createUserWithEmailAndPassword(email, pass)
                    //memeriksa apakah synctask nya udah berhasil atau belum
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                Toast.makeText(Login.this, "Regsiter Success", Toast.LENGTH_LONG).show();
                                FirebaseUser user = mAuth.getCurrentUser();

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }
    }

    public void Login(View view) {
        String email=mEmail.getText().toString();
        String pass=mPass.getText().toString();
        //jika field nya tidak terisi maka akan muncul toast
        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(pass)) {
            Toast.makeText(Login.this, "Doesn't allow empty", Toast.LENGTH_LONG).show();

            //untuk sign in melalui email dan password
        }else {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(Login.this,MainActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }}
}
