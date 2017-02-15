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

public class AwareHumanResourcePdfActivity2 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_resource_pdf2);

        webView = (WebView) findViewById(R.id.webView);

        Intent intentHumanResource = getIntent();
        AwareModel awareModel = intentHumanResource.getParcelableExtra("AwareModel");

        //int listId = awareModel.getListId();
        String pptxName = awareModel.getName();

        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(appDirectory + "/KnowledgeBase/HR/Human Resource/Induction Module Frontliners/"+pptxName+".pptx");

        if(file.exists()) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            //Uri uri = Uri.fromFile(file);
            intent.setDataAndType(Uri.fromFile(file), "application/msword");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(AwareHumanResourcePdfActivity2.this, "No Application Available to View PDF",
                        Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(AwareHumanResourcePdfActivity2.this, "PPT does not exixt",
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
