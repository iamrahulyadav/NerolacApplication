package com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.abc.nerolac.R;

import java.io.File;

public class EquipOtherPdfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip_other_pdf);
        Intent intentEquipColorOfTheYear = getIntent();
        String pdfName = intentEquipColorOfTheYear.getStringExtra("OTHER");

        //int listId = awareModel.getListId();
        //String pdfName = awareModel.getName();

        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(appDirectory + "/KnowledgeBase/CUSTOMER/"+pdfName+".pdf");

        if(file.exists()) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            //Uri uri = Uri.fromFile(file);
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(EquipOtherPdfActivity.this, "No Application Available to View PDF",
                        Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(EquipOtherPdfActivity.this, "PDF does not exixt",
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
