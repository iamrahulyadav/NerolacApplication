package com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.VideoActivity;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.abc.nerolac.R;
import com.abc.nerolac.model.AssistModel;
import com.abc.nerolac.model.EquipModel;

import java.io.File;

public class AssistCustomerVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_customer_video);

        VideoView videoView;

        Intent intentAssistCustomer = getIntent();
        AssistModel assistModel = intentAssistCustomer.getParcelableExtra("AssistModel");

        String videoName = assistModel.getName();

        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();

        File file = new File(appDirectory+"/KnowledgeBase/SELF TRAINING/Customer/"+videoName+".mp4");

        String file1 = appDirectory+"/KnowledgeBase/SELF TRAINING/Customer/"+videoName+".mp4";


        if(file.exists()) {
            videoView = (VideoView) findViewById(R.id.videoView);
//        videoView.setVideoPath("storage/sdcard0/Nerolac/Data/2.mp4");  //old path
            videoView.setVideoPath(file1);
//        videoView.setVideoPath("storage/extSdCard/Nerolac/Data/2.mp4");   // new path


            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);

            videoView.start();
        }else {
            Toast.makeText(this, "Video is not available", Toast.LENGTH_SHORT).show();
            finish();
        }



        /*Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("storage/sdcard0/Nerolac/Data/2.mp4"), "video/mp4");
        startActivity(intent);*/
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
