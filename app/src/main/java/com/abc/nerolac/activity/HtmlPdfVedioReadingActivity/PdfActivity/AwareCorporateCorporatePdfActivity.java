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

public class AwareCorporateCorporatePdfActivity extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aware_corporate_corporate_pdf);

        mWebView = (WebView) findViewById(R.id.webView);

        Intent intentCorporateCommunication = getIntent();
        AwareModel awareModel = intentCorporateCommunication.getParcelableExtra("AwareModel");

        //int listId = awareModel.getListId();
        String pdfName = awareModel.getName();

        String appDirectory = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(appDirectory + "/KnowledgeBase/HR/Corporate Communication/Corporate Communication/" + pdfName + ".pdf");

        if (file.exists()) {

            Intent intent = new Intent();
            //intent.setPackage("com.adobe.reader");
            intent.setAction(Intent.ACTION_VIEW);
            //Uri uri = Uri.fromFile(file);

            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {

                Toast.makeText(AwareCorporateCorporatePdfActivity.this, "No Application Available to View PDF",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(AwareCorporateCorporatePdfActivity.this, "PDF does not exixt",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (AwareCorporateCommunicationPdfActivity.this.isFinishing()){
//            startActivity(new Intent(AwareCorporateCommunicationPdfActivity.this,AwareCorporateCommunicationActivity.class));
//        }
//    }
//
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        startActivity(new Intent(AwareCorporateCommunicationPdfActivity.this, AwareCorporateCommunicationActivity.class));
//
//    }



}
