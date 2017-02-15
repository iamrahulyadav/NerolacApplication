package com.abc.nerolac.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.abc.nerolac.R;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.EquipKnplProductPdfActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.LoginHowItWorkPdfActivity;
import com.abc.nerolac.model.User;
import com.abc.nerolac.utility.Constants;

public class LoginActivity extends AppCompatActivity {

    Button buttonLogin;
    EditText userName, userPassword;
    //CheckBox checkboxRememberMe;
    TextView textRegister,textForgotPassword, knowAboutKnowledgeManagement, enterLoginDetails;

    Intent intent;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/roboto.thin.ttf");

        enterLoginDetails = (TextView) findViewById(R.id.enterLoginDetails);
        enterLoginDetails.setTypeface(typeface);

        knowAboutKnowledgeManagement = (TextView) findViewById(R.id.knowAboutKnowledgeManagement);
        knowAboutKnowledgeManagement.setTypeface(typeface);
        knowAboutKnowledgeManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, LoginHowItWorkPdfActivity.class);
                String pdfName = "HowItWorks";
                intent.putExtra("How_It_Works", pdfName);
                startActivity(intent);
            }
        });

        textForgotPassword = (TextView) findViewById(R.id.textForgotPassword);
        textForgotPassword.setTypeface(typeface);
        textForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });


        textRegister = (TextView) findViewById(R.id.textRegister);
        textRegister.setTypeface(typeface);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij = new Intent(LoginActivity.this, SingUpActivity.class);
                startActivity(ij);
            }
        });


        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        userName = (EditText) findViewById(R.id.uname);
        userName.setText(preferences.getString(Constants.LOGIN_USER_NAME,null));

        userPassword = (EditText) findViewById(R.id.upassword);
        //checkboxRememberMe = (CheckBox) findViewById(R.id.checkboxRememberMe);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        //buttonSingUp = (Button) findViewById(R.id.buttonSingUp);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().length() == 0) {
                    Toast.makeText(LoginActivity.this, "enter user name", Toast.LENGTH_SHORT).show();
                } else if (userPassword.getText().toString().length() == 0) {
                    Toast.makeText(LoginActivity.this, "enter password", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User();
                    user.setUserName(userName.getText().toString());
                    user.setUserPassword(userPassword.getText().toString());
                    /*if (user.authenticate(LoginActivity.this, checkboxRememberMe.isChecked()) == true) {
                        Intent ij = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(ij);
                    } else {
                        Toast.makeText(getApplicationContext(),"Invalid User name ot password",Toast.LENGTH_SHORT).show();
                    }*/
                    if (user.authenticate(LoginActivity.this) == true) {
                        Intent ij = new Intent(LoginActivity.this, MenuActivity.class);

                        ij.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ij.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        ij.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        ij.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                        //ij.putExtra("LoginName",user.getUserName());
                        startActivity(ij);

                    } else {
                        Toast.makeText(getApplicationContext(),"Invalid User name or password",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

   /* @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        userName.setText(preferences.getString(Constants.LOGIN_USER_NAME,null));
    }*/

    /*public void buttonLogin(View view) {

    }
    */

    /*public void buttonSingUp(View view) {
        Intent ij = new Intent(LoginActivity.this, SingUpActivity.class);
        startActivity(ij);
    }*/

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }*/

    @Override
    protected void onResume() {
        super.onResume();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        userName = (EditText) findViewById(R.id.uname);
        userName.setText(preferences.getString(Constants.LOGIN_USER_NAME, null));

        /*intent = getIntent();
        userName.setText(intent.getStringExtra("UserName"));*/
        //userName.setText(intent.getStringExtra("UserName"));
        //finish();
    }
}
