package com.abc.nerolac.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.utility.Constants;

public class AssistActivity extends AppCompatActivity {

    Button buttonCustomer, buttonKeyInfo, buttonReports, buttonSelf, buttonTransaction;

    Button buttonOther, buttonHelpDesk;

    Button buttonInductionModule;

    TextView text1,text2,text3;

    ImageView imageHome, imageBack, imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/roboto.thin.ttf");

        text1 = (TextView) findViewById(R.id.text1);
        //text1.setText("Theme of 2016-17");
        text1.setTypeface(typeface);

        text2 = (TextView) findViewById(R.id.text2);
        //text2.setText("Aggressive Growth:");
        text2.setTypeface(typeface);

        text3 = (TextView) findViewById(R.id.text3);
        //text3.setText("Confidently March Ahead");
        text3.setTypeface(typeface);

        /*final Intent intentLoginName = getIntent();
        final String loginName = intentLoginName.getStringExtra("LoginName");*/

        /*textBack = (TextView) findViewById(R.id.textBack);
        //textBack.setTypeface(typeface);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AssistActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME,null);

        textUserName = (TextView) findViewById(R.id.textUserName);
        //textUserName.setTypeface(typeface);
        textUserName.setText(userName);*/

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AssistActivity.this,MenuActivity.class));
            }
        });

        imageBack = (ImageView) findViewById(R.id.imageBack);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(AwareActivity.this,MenuActivity.class));
                finish();
            }
        });

        imageLogout = (ImageView) findViewById(R.id.imageLogout);
        imageLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AssistActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(AssistActivity.this, LoginActivity.class);

                        ij.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ij.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        ij.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        ij.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                        startActivity(ij);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();
                //startActivity(new Intent(AwareActivity.this, MenuActivity.class));
            }
        });

        buttonInductionModule = (Button) findViewById(R.id.buttonInductionModule);
        buttonInductionModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistActivity.this,AssistInductionModuleActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonHelpDesk = (Button) findViewById(R.id.buttonHelpDesk);
        buttonHelpDesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistActivity.this,AssistHelpDeskActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonOther = (Button) findViewById(R.id.buttonOther);
        buttonOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistActivity.this,AssistOtherActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonCustomer = (Button) findViewById(R.id.buttonCustomer);
        buttonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistActivity.this,AssistCustomerActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonKeyInfo = (Button) findViewById(R.id.buttonKeyInfo);
        buttonKeyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistActivity.this,AssistKeyInfoActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonReports = (Button) findViewById(R.id.buttonReports);
        buttonReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistActivity.this,AssistReportsActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonSelf = (Button) findViewById(R.id.buttonSelf);
        buttonSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistActivity.this,AssistSelfActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonTransaction = (Button) findViewById(R.id.buttonTransaction);
        buttonTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistActivity.this,AssistTransactionActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

    }

}
