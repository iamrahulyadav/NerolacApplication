package com.abc.nerolac.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.abc.nerolac.DB.DBHelper;
import com.abc.nerolac.R;
import com.abc.nerolac.model.User;
import static com.abc.nerolac.utility.Constants.*;

import java.util.ArrayList;

import static com.abc.nerolac.model.User.*;

public class SingUpActivity extends AppCompatActivity {

    EditText editEmailId, editPassowrd, editSecurityAnswer;

    EditText editName, editMobile, editTerritory;

    Spinner spinnerSecurityQuestion;
    ArrayList<String> questionArrayList;
    ArrayAdapter<String> adapterSpinner;
    String finalQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        questionArrayList = new ArrayList<>();

        editName = (EditText) findViewById(R.id.editName);
        editMobile = (EditText) findViewById(R.id.editMobile);
        editTerritory = (EditText) findViewById(R.id.editTerritory);
        editEmailId = (EditText) findViewById(R.id.editEmailId);
        //editUserName = (EditText) findViewById(R.id.editUserName);
        editPassowrd = (EditText) findViewById(R.id.editPassowrd);
        editSecurityAnswer = (EditText) findViewById(R.id.editSecurityAnswer);

        //editEmailId.addTextChangedListener(emailWatcher);

        questionArrayList.add("What is your pet name?");
        questionArrayList.add("What is your school name?");
        questionArrayList.add("What is your favourite food?");
        questionArrayList.add("What is your favourite movie?");
        questionArrayList.add("What is your favourite place?");

        spinnerSecurityQuestion = (Spinner) findViewById(R.id.spinnerSecurityQuestion);
        adapterSpinner = new ArrayAdapter<String>(this,R.layout.spinner,questionArrayList);
        spinnerSecurityQuestion.setAdapter(adapterSpinner);

        spinnerSecurityQuestion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                finalQuestion = questionArrayList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /*private TextWatcher emailWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
             editUserName.setText(editEmailId.getText());
        }
    };*/

    public void buttonRegister(View view) {

        if(editName.getText().toString().length() == 0) {
            Toast.makeText(this,"Please Enter Name",Toast.LENGTH_SHORT).show();
        }else if(editMobile.getText().toString().length() == 0) {
            Toast.makeText(this,"Please Enter Mobile Number",Toast.LENGTH_SHORT).show();
        }else if(editTerritory.getText().toString().length() == 0) {
            Toast.makeText(this,"Please Enter Territory Details",Toast.LENGTH_SHORT).show();
        } else if(editEmailId.getText().toString().length() == 0) {
            Toast.makeText(this,"Please Enter Email Id",Toast.LENGTH_SHORT).show();
        }else if(editPassowrd.getText().toString().length() == 0) {
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
        }else if(editSecurityAnswer.getText().toString().length() == 0) {
            Toast.makeText(this,"Please the answer",Toast.LENGTH_SHORT).show();
        }
        else {

            User user = new User();

            user.setName(editName.getText().toString());
            user.setMobileNumber(editMobile.getText().toString());
            user.setTerritory(editTerritory.getText().toString());
            user.setEmailID(editEmailId.getText().toString());
            //user.setUserName(editUserName.getText().toString());
            user.setUserPassword(editPassowrd.getText().toString());
            user.setSecurityQuestion(finalQuestion);
            user.setSecurityQuestionAnswer(editSecurityAnswer.getText().toString());


            if(user.insert(this) == true) {


                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                preferences.edit().putString(LOGIN_USER_NAME,editEmailId.getText().toString())
                        .putBoolean(FIRST_TIME_REGISTER,true)
                        .commit();

                Intent intent = new Intent(SingUpActivity.this,LoginActivity.class);
                //intent.putExtra("UserName",editUserName.getText().toString());

                startActivity(intent);
                //finish();
            }
        }
    }

}
