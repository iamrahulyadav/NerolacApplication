package com.abc.nerolac.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.model.User;

import java.util.ArrayList;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText editEmail, editSecurityQuestion, editSeucrityQuestionAnswer;
    TextView textSetPassword;
    Button getPassword;

    Spinner spinnerSecurityQuestion;
    ArrayList<String> questionArrayList;
    ArrayAdapter<String> adapterSpinner;

    String finalQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editEmail = (EditText) findViewById(R.id.editEmailId);

        questionArrayList = new ArrayList<>();
        questionArrayList.add("What is your pet name?");
        questionArrayList.add("What is your school name?");
        questionArrayList.add("What is your favourite food?");
        questionArrayList.add("What is your favourite movie?");
        questionArrayList.add("What is your favourite place?");

        spinnerSecurityQuestion = (Spinner) findViewById(R.id.spinnerSecurityQuestion);
        adapterSpinner = new ArrayAdapter<String>(this,R.layout.spinner,questionArrayList);
        spinnerSecurityQuestion.setAdapter(adapterSpinner);

        editSeucrityQuestionAnswer = (EditText) findViewById(R.id.editSeucrityQuestionAnswer);

        textSetPassword = (TextView) findViewById(R.id.textSetPassword);

        getPassword = (Button) findViewById(R.id.getPassword);
        getPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();

                String emailId = editEmail.getText().toString();
                /*spinnerSecurityQuestion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        finalQuestion = questionArrayList.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });*/

                String securityQuestion = spinnerSecurityQuestion.getSelectedItem().toString();
                String securityAnswer = editSeucrityQuestionAnswer.getText().toString();

                String password = user.getForgotPassword(ForgotPasswordActivity.this, emailId, securityQuestion,securityAnswer);

                textSetPassword.setText(password);
            }
        });

    }


}
