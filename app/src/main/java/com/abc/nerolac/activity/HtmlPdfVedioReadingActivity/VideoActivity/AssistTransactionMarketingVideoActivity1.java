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

import java.io.File;

public class AssistTransactionMarketingVideoActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_transaction_marketing_video1);

        VideoView videoView;

        Intent intentAssistTransactionMarketing = getIntent();
        String videoName = intentAssistTransactionMarketing.getStringExtra("VideoName");

        //String videoName = assistModel.getName();

        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();

        File file = new File(appDirectory+"/KnowledgeBase/SELF TRAINING/Transaction/Marketing Module/"+videoName+".mp4");


        String file1 = appDirectory+"/KnowledgeBase/SELF TRAINING/Transaction/Marketing Module/"+videoName+".mp4";

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

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
