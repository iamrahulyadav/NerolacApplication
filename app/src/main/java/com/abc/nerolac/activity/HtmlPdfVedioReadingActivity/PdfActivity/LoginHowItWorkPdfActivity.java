package com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import com.abc.nerolac.R;
import com.abc.nerolac.model.EquipModel;

import java.io.File;

public class LoginHowItWorkPdfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_how_it_work_pdf);

        WebView mWebView = (WebView) findViewById(R.id.webView);

        Intent intentHowItWorks = getIntent();
        String pdfName = intentHowItWorks.getStringExtra("How_It_Works");

        //int listId = awareModel.getListId();
        //String pdfName = awareModel.getName();

        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(appDirectory + "/KnowledgeBase/"+pdfName+".pdf");

        if(file.exists()) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            //Uri uri = Uri.fromFile(file);
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(LoginHowItWorkPdfActivity.this, "No Application Available to View PDF",
                        Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(LoginHowItWorkPdfActivity.this, "PDF does not exixt",
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
