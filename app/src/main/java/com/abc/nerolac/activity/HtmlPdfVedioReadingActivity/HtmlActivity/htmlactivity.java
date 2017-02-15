package com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.HtmlActivity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import com.abc.nerolac.R;

import java.io.File;

public class htmlactivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlactivity);

        webView = (WebView) findViewById(R.id.webView);
//        File file = new File("storage/sdcard0/Nerolac/Data/html/index.html");  //old path
//        File file = new File("storage/extSdCard/Nerolac/Data/html/index.html");   // new path


        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(appDirectory+"/knowledgeBase/html/index.html");

        //if(file.exists()) {
            webView.loadUrl("file:///"+file);
        /*}else {
            Toast.makeText(this,"HTML page is not available",Toast.LENGTH_SHORT).show();
        }*/


//        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();
//        Log.e("path", appDirectory);
    }

}
