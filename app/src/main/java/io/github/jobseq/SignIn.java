package io.github.jobseq;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class SignIn extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private TextView attempt;
    private Button login;
    private Button signup;
    private int counter = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        attempt = (TextView) findViewById(R.id.textView4);
        login = (Button) findViewById(R.id.btn_login);
        signup = (Button) findViewById(R.id.btn_signup);

        attempt.setText("Number of attempts : 3");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(email.getText().toString(),password.getText().toString());
//                converts text to string
            }
        });

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v2){
                Intent iprev = new Intent(SignIn.this, LogInActivity.class);
                startActivity(iprev);
//                this will take you to sign up page
            }
        });

    }


    private void validate(String email, String password){
        if((email.equals("admin") )&&(password.equals("1234"))){
            Intent intent = new Intent(SignIn.this, HomePage.class);
            startActivity(intent);
//            this will take you to homepage

        }
        else{
            counter --;
            attempt.setText("Number of attempts:"+String.valueOf(counter));
            if (counter == 0)
            {
                login.setEnabled(false);
                signup.setEnabled(false);
//                this will disable both buttons after 3 wrong attempts
            }
        }
    }
}