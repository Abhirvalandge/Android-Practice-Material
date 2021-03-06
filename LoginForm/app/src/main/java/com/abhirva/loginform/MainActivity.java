package com.abhirva.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText email;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();
    }

    public void LoginButton(){
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        attempts = (TextView)findViewById(R.id.count_attempt);
        login_btn = (Button) findViewById(R.id.email_sign_in_button);

        attempts.setText(Integer.toString(attempt_counter));

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(email.getText().toString().equals("abhirva") &&
                                password.getText().toString().equals("landge")){
                            Toast.makeText(MainActivity.this, "Email & Password is correct", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(".userActivity");
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this, "Email & Password is incorrect", Toast.LENGTH_SHORT).show();
                            attempt_counter--;
                            attempts.setText(Integer.toString(attempt_counter));
                            if (attempt_counter == 0){
                                login_btn.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }
}
