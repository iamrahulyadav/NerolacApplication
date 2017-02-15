package com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.abc.nerolac.R;
import com.abc.nerolac.model.AwareModel;

import java.io.File;

public class AwarePaintIndutryPdfActivity extends AppCompatActivity {

    File directory;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfactivity);

        mWebView = (WebView) findViewById(R.id.webView);
//        String path = Environment.getDataDirectory().toString()+"/storage/sdcard0/Nerolac/Data/1.pdf";

//        mWebView = (WebView) findViewById(R.id.webView);

        Intent intentPaintIndustry = getIntent();
        AwareModel awareModel = intentPaintIndustry.getParcelableExtra("AwareModel");

        //int listId = awareModel.getListId();
        String pdfName = awareModel.getName();

        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();

        File file = new File(appDirectory + "/KnowledgeBase/CUSTOMER/Paint Industry/"+pdfName+".pdf");

        /*if(listId == 1) {
            file = new File(appDirectory + "/Nerolac/Data/Paint Industry Facts.pdf"); //old path
        }else if(listId == 2) {
            file = new File(appDirectory + "/Nerolac/Data/Kansai Japan.pdf"); //old path
        }else if(listId == 3) {
            file = new File(appDirectory + "/Nerolac/Data/Kansai Nerolac Paint Ltd.pdf"); //old path
        }*/

//        File file = new File("/storage/extSdCard/Nerolac/Data/1.pdf");    //new path

//        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.invalidate();
//        mWebView.getSettings().setLoadWithOverviewMode(true);
//        mWebView.getSettings().setUseWideViewPort(true);
//        mWebView.loadData("file:///" + file ,"application/pdf", "UTF-8");



//    /*  mWebView.loadUrl("file:///" + file);
//        Intent intent = new Intent(Intent.ACTION_VIEW,
//                Uri.parse("storage/sdcard0/Nerolac/Data/1.pdf"));
/*

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("/storage/extSdCard/Nerolac/Data/1.pdf"));
        intent.setType("application/pdf");

        startActivity(intent);

//      String appDirectory = (System.getenv("SECONDARY_STORAGE") == null)
//                ? Environment.getExternalStorageDirectory().getAbsolutePath()
//                : System.getenv("SECONDARY_STORAGE");

*/
//          String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();


//        Log.e("path", appDirectory);





//        mWebView.loadUrl(path);


        //File file = new File(Environment.getExternalStorageDirectory() + "/pdf/original.pdf");
        //PackageManager packageManager = getPackageManager();
        //Intent testIntent = new Intent(Intent.ACTION_VIEW);
        //testIntent.setType("application/pdf");
        //List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);

        if(file.exists()) {

            Intent intent = new Intent();

            //intent.setPackage("com.adobe.reader");
            intent.setAction(Intent.ACTION_VIEW);
            //Uri uri = Uri.fromFile(file);

            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {

                Toast.makeText(AwarePaintIndutryPdfActivity.this, "No Application Available to View PDF",
                        Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(AwarePaintIndutryPdfActivity.this, "PDF does not exixt",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
