package com.abc.nerolac.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.adapter.EquipAdapter;
import com.abc.nerolac.model.EquipModel;
import com.abc.nerolac.utility.Constants;

import java.util.ArrayList;

public class EquipInfluencerProgramActivity extends AppCompatActivity {

    EquipAdapter equipAdapter;
    ArrayList<EquipModel> modelArrayList;

    ListView listView;

    TextView textListViewTitle, textUserName, textBack;

    TextView text1,text2,text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip_influencer_program);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/roboto.thin.ttf");

        text1 = (TextView) findViewById(R.id.text1);
        //text1.setText("Theme of 2016-17");
        text1.setTypeface(typeface);

        text2 = (TextView) findViewById(R.id.text2);
        //text2.setText("Aggressive Growth:");
        text2.setTypeface(typeface);

        text3 = (TextView) findViewById(R.id.text3);
        //text3.setText("Confidently March Ahead");
        text3.setTypeface(typeface);

        /*final Intent intentLoginName = getIntent();
        final String loginName = intentLoginName.getStringExtra("LoginName");*/

        /*textBack = (TextView) findViewById(R.id.textBack);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(EquipInfluencerProgramActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME,null);*/

        /*textUserName = (TextView) findViewById(R.id.textUserName);
        //textUserName.setTypeface(typeface);
        textUserName.setText(userName);*/

        textListViewTitle= (TextView) findViewById(R.id.textListViewTitle);
        textListViewTitle.setText("INFUENCER PROGRAM");

        modelArrayList = new ArrayList<>();
        modelArrayList.add(new EquipModel("KNPL influencer programs",R.drawable.pdf_icon));
        modelArrayList.add(new EquipModel("Competition Comparison",R.drawable.pdf_icon));


        listView = (ListView) findViewById(R.id.listView);
        equipAdapter = new EquipAdapter(this,modelArrayList);
        listView.setAdapter(equipAdapter);
    }


}
