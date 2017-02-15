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

public class AssistKeyInfoVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_key_info_video);

        VideoView videoView;

        videoView = (VideoView) findViewById(R.id.videoView);

        Intent intentAssistKeyInfo= getIntent();
        AssistModel assistModel = intentAssistKeyInfo.getParcelableExtra("AssistModel");

        String videoName = assistModel.getName();

        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();

        File file = new File(appDirectory+"/KnowledgeBase/SELF TRAINING/Key Info/"+videoName+".mp4");

        String file1 = appDirectory+"/KnowledgeBase/SELF TRAINING/Key Info/"+videoName+".mp4";

        videoView.setVideoPath(file1);

        if(file.exists()) {

//        videoView.setVideoPath("storage/sdcard0/Nerolac/Data/2.mp4");  //old path

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
