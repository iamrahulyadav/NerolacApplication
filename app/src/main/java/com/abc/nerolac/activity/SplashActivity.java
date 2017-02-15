package com.abc.nerolac.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.abc.nerolac.R;

import java.io.File;

import static com.abc.nerolac.utility.Constants.*;


public class SplashActivity extends AppCompatActivity {

    //WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //webView = (WebView) findViewById(R.id.webView);

        Handler handler = new Handler();
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        handler.postDelayed(runnable,3000);

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }, 3000);*/
    }

    /*SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
      if(sharedPreferences.getBoolean(Constants.LOGIN_STATUS, true)) {
           startActivity(new Intent(SplashActivity.this, MenuActivity.class));
              }else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }*/

                /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
                String userName = preferences.getString(Constants.LOGIN_USER_NAME,null);*/

               /* SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
                if(sharedPreferences.getBoolean(FIRST_TIME_REGISTER, true)) {

                    webView.setVisibility(View.GONE);
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                }else {

                    webView.setVisibility(View.VISIBLE);

                    String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();
                    File file = new File(appDirectory + "/KnowledgeBase/HowItWorks.pdf");

                    if(file.exists()) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        //Uri uri = Uri.fromFile(file);

                        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            startActivity(intent);
                        } catch (ActivityNotFoundException e) {

                            Toast.makeText(SplashActivity.this, "No Application Available to View PDF",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SplashActivity.this, "PDF does not exixt",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }*/

    /*@Override
    protected void onPause() {
        super.onPause();
        finish();
    }*/
}
