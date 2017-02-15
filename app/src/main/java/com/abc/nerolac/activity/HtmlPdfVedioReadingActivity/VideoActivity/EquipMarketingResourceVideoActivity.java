package com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.VideoActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import com.abc.nerolac.R;
import com.abc.nerolac.model.AwareModel;
import com.abc.nerolac.model.EquipModel;

import java.io.File;

public class EquipMarketingResourceVideoActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intentMarketingResource = getIntent();
        EquipModel equipModel = intentMarketingResource.getParcelableExtra("EquipModel");

        videoView = (VideoView) findViewById(R.id.videoView);

        String videoName = equipModel.getName();

        String appDirectory =  Environment.getExternalStorageDirectory().getAbsolutePath();

        File file = new File(appDirectory+"/KnowledgeBase/CUSTOMER/Marketing Resources/"+videoName+".mp4");

        String file1 = appDirectory+"/KnowledgeBase/CUSTOMER/Marketing Resources/"+videoName+".mp4";



        //Uri uri=Uri.parse(appDirectory+"/KnowledgeBase/Equip/Marketing Resources/"+videoName+".mp4");



        if(file.exists()) {

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);

            videoView.setVideoPath(file1);
            videoView.setMediaController(mediaController);
            videoView.start();

        }else {
            Toast.makeText(this,"Video is not available",Toast.LENGTH_SHORT).show();
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
