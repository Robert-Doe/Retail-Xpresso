package com.robertory.stockpot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

            Button btnSignIn,btnSignUp;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            btnSignIn=(Button)findViewById(R.id.btnLogIn);
            btnSignUp=(Button)findViewById(R.id.btnSignUp);
            btnSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder= new AlertDialog.Builder(LoginActivity.this);
                    View view=getLayoutInflater().inflate(R.layout.activity_log_in,null);
                    final EditText etUserName=(EditText)view.findViewById(R.id.etUserId);
                    final EditText etPassword=(EditText)view.findViewById(R.id.etPassword);
                    final Button btnLogin=(Button)view.findViewById(R.id.btnLogin);

                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                    if(ErrorCorrection(etUserName) && ErrorCorrection(etPassword))
                    {
                        Intent intent=new Intent(LoginActivity.this,AdminDashboard.class);
                          startActivity(intent);
                      }

                        }
                    });
                    builder.setView(view);
                    AlertDialog dialog= builder.create();
                    dialog.show();
                }
            });
        }


        public boolean ErrorCorrection(EditText v)
        {
            if(v.getText().toString().isEmpty())
            {
                v.setError("Please Fill Space");
                return false;
            }
            return true;
        }
}

