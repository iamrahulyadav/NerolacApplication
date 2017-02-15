package com.abc.nerolac.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.abc.nerolac.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MenuActivity extends AppCompatActivity {

    //TextView logoutText;
    Button buttonAware, buttonEquip, buttonAssist;

    ImageView imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Text file reading started
        File sdcard = Environment.getExternalStorageDirectory();
        //Get the text file
        File file = new File(sdcard,"/KnowledgeBase/textFile.txt");
        //Read text from file
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
            e.printStackTrace();
        }

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/roboto.thin.ttf");

        TextView marque = (TextView) this.findViewById(R.id.marque_scrolling_text);
        marque.setText(text.toString());
        marque.setTypeface(typeface);
        marque.setSelected(true);    // marquee text file reading end here

        Intent intent = getIntent();
        final String loginName = intent.getStringExtra("LoginName");

        //logoutText = (TextView) findViewById(R.id.logout);

        buttonAware = (Button) findViewById(R.id.buttonAware);
        buttonEquip = (Button) findViewById(R.id.buttonEquip);
        buttonAssist = (Button) findViewById(R.id.buttonAssist);
        //buttonBlog = (Button) findViewById(R.id.buttonBlog);

        buttonAware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij = new Intent(MenuActivity.this, AwareActivity.class);
                ij.putExtra("LoginName",loginName);
                startActivity(ij);
            }
        });

        buttonEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij = new Intent(MenuActivity.this, EquipActivity.class);
                ij.putExtra("LoginName",loginName);
                startActivity(ij);
            }
        });

        buttonAssist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij = new Intent(MenuActivity.this, AssistActivity.class);
                ij.putExtra("LoginName",loginName);
                startActivity(ij);
            }
        });

        /*buttonBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ij = new Intent(MenuActivity.this, BlogActivity.class);
                startActivity(ij);
            }
        });*/

        imageLogout = (ImageView) findViewById(R.id.imageLogout);
        imageLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(MenuActivity.this, LoginActivity.class);

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

        /*logoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are You Sure You Want To Logout?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        *//*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MenuActivity.this);
                        preferences.edit().putBoolean(Constants.LOGIN_STATUS,false).commit();

                        startActivity(new Intent(MenuActivity.this,LoginActivity.class));*//*

                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MenuActivity.this);
                        preferences.edit().clear().commit();

                        startActivity(new Intent(MenuActivity.this,LoginActivity.class));
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.create().show();
            }
        });*/
    }

}
