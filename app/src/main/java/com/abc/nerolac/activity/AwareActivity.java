package com.abc.nerolac.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.utility.Constants;

public class AwareActivity extends AppCompatActivity {

    Button buttonCorporateCommunication, buttonHumanResource;

    //TextView textBack,textUserName;

    ImageView imageHome, imageBack, imageLogout;

    TextView text1,text2,text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aware);

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



        /*Intent intentLoginName = getIntent();
        final String loginName = intentLoginName.getStringExtra("LoginName");*/

        /*textBack = (TextView) findViewById(R.id.textBack);
        textBack.setTypeface(typeface);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AwareActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME,null);

        textUserName = (TextView) findViewById(R.id.textUserName);
        textUserName.setTypeface(typeface);
        textUserName.setText(userName);*/

        /*buttonPaintIndustry = (Button) findViewById(R.id.buttonPaintIndustry);
        buttonPaintIndustry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwareActivity.this,AwarePaintIndustryActivity.class);
                //intent.putExtra("LoginName",intentLoginName.getStringExtra("LoginName"));
                startActivity(intent);
            }
        });*/

        buttonCorporateCommunication = (Button) findViewById(R.id.buttonCorporateCommunication);
        buttonCorporateCommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwareActivity.this,AwareCorporateCommunicationActivity.class);
                //intent.putExtra("LoginName",intentLoginName.getStringExtra("LoginName"));
                startActivity(intent);
            }
        });

        buttonHumanResource = (Button) findViewById(R.id.buttonHumanResource);
        buttonHumanResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwareActivity.this,AwareHumanResourseActivity.class);
                //intent.putExtra("LoginName",intentLoginName.getStringExtra("LoginName"));
                startActivity(intent);
            }
        });

        /*buttonPricing = (Button) findViewById(R.id.buttonPricing);
        buttonPricing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwareActivity.this, AwarePricingActivity.class);
                //intent.putExtra("LoginName",intentLoginName.getStringExtra("LoginName"));
                startActivity(intent);
            }
        });*/

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AwareActivity.this,MenuActivity.class));
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

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AwareActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(AwareActivity.this, LoginActivity.class);

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
    }

    /*@Override
    protected void onResume() {
        super.onResume();

        textUserName = (TextView) findViewById(R.id.textUserName);
        //textUserName.setTypeface(typeface);
        textUserName.setText(intentLoginName.getStringExtra("LoginName"));

    }*/
}
