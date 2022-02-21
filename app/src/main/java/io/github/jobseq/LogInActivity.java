package io.github.jobseq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    Button sign_in,sign_up;
    TextView skip;
    EditText e1,e2,e3,e4;
    RadioButton r1,r2;
    RadioGroup rg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_activity);
        sign_up = (Button) findViewById(R.id.register);
        sign_in = (Button) findViewById(R.id.sign_in);
        skip = (TextView) findViewById(R.id.skip_button);
        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.mail);
        e3 = (EditText) findViewById(R.id.pass);
        e4 = (EditText) findViewById(R.id.phone);
        r1 = (RadioButton) findViewById(R.id.male);
        r2 = (RadioButton) findViewById(R.id.female);
        rg1 = (RadioGroup) findViewById(R.id.gender);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty() || e3.getText().toString().isEmpty() || e4.getText().toString().isEmpty() || (r1.isChecked()==false && r2.isChecked()==false)){
                    Toast.makeText(getApplicationContext(),"Invalid Credentials! Enter Again",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Account Created Successfully",Toast.LENGTH_SHORT).show();
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    rg1.clearCheck();
                }
            }
        });
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(LogInActivity.this,SignIn.class);
                startActivity(i1);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(LogInActivity.this,HomePage.class);
                startActivity(i2);
            }
        });
    }
}