package com.abc.nerolac.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.VideoActivity.AssistSelfVideoActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.VideoActivity.AssistTransactionVideoActivity;
import com.abc.nerolac.adapter.AssistAdapter;
import com.abc.nerolac.model.AssistModel;
import com.abc.nerolac.utility.Constants;

import java.util.ArrayList;

public class AssistTransactionActivity extends AppCompatActivity {

    Button buttonMarketingModule, buttonProjectModule, buttonSupport, buttonVisit;

    TextView textListViewTitle, textBack, textLogout;
    ListView listView1, listView2;

    ArrayList<AssistModel> modelArrayList1, modelArrayList2;
    AssistAdapter assistAdapter;

    TextView text1,text2,text3;

    ImageView imageHome, imageBack, imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_transaction);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/roboto.thin.ttf");

        text1 = (TextView) findViewById(R.id.text1);
        //text1.setText("Theme of 2016-17");
        text1.setTypeface(typeface);

        text2 = (TextView) findViewById(R.id.text2);
        //text2.setText("Aggressive Growth:");
        text2.setTypeface(typeface);

        text3 = (TextView) findViewById(R.id.text3);
        //text3.setText("Confidently March Ahead");
        text3.setTypeface(typeface);

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AssistTransactionActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME, null);*/

        /*textLogout = (TextView) findViewById(R.id.textLogout);
        textLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AssistTransactionActivity.this);
                preferences.edit().clear().commit();

                startActivity(new Intent(AssistTransactionActivity.this, LoginActivity.class));
            }
        });*/


        /*textBack = (TextView) findViewById(R.id.textBack);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        buttonMarketingModule = (Button) findViewById(R.id.buttonMarketingModule);
        buttonMarketingModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistTransactionActivity.this,AssistTransactionMarketingModuleActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonProjectModule = (Button) findViewById(R.id.buttonProjectModule);
        buttonProjectModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistTransactionActivity.this, AssistTransactionProjectModuleActivity.class);
                //intent.putExtra("LoginName", loginName);
                startActivity(intent);
            }
        });

        buttonSupport = (Button) findViewById(R.id.buttonSupport);
        buttonSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistTransactionActivity.this,AssistTransactionSupportActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonVisit = (Button) findViewById(R.id.buttonVisit);
        buttonVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssistTransactionActivity.this,AssistVisitActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        Typeface listTitleTypesafe = Typeface.createFromAsset(getAssets(),"fonts/roboto.bold.ttf");


        textListViewTitle = (TextView) findViewById(R.id.textListViewTitle);
        textListViewTitle.setText("Transaction");
        textListViewTitle.setTypeface(listTitleTypesafe);

        modelArrayList1 = new ArrayList<>();
        modelArrayList1.add(new AssistModel("Expenses Module", R.drawable.video_icon));
        modelArrayList1.add(new AssistModel("Prospect Creation", R.drawable.video_icon));
        modelArrayList1.add(new AssistModel("Integrated Planning", R.drawable.video_icon));
        //modelArrayList1.add(new AssistModel("Visit Info", R.drawable.video_icon));
        //modelArrayList1.add(new AssistModel("Zback Visit", R.drawable.video_icon));

        listView1 = (ListView) findViewById(R.id.listView1);
        assistAdapter = new AssistAdapter(this,modelArrayList1);
        listView1.setAdapter(assistAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AssistModel assistModel = modelArrayList1.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AssistTransactionActivity.this, AssistTransactionVideoActivity.class);
                intent.putExtra("AssistModel", assistModel);
                startActivity(intent);

            }
        });

        /*modelArrayList2 = new ArrayList<>();
        modelArrayList2.add(new AssistModel("Integrated Planning", R.drawable.video_icon));
        modelArrayList2.add(new AssistModel("Prospect Creation", R.drawable.video_icon));
        modelArrayList2.add(new AssistModel("Visit Review", R.drawable.video_icon));


        listView2 = (ListView) findViewById(R.id.listView2);
        assistAdapter = new AssistAdapter(this,modelArrayList2);
        listView2.setAdapter(assistAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AssistModel assistModel = modelArrayList2.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AssistTransactionActivity.this, AssistTransactionVideoActivity.class);
                intent.putExtra("AssistModel", assistModel);
                startActivity(intent);

            }
        });*/

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AssistTransactionActivity.this,MenuActivity.class));
            }
        });

        imageBack = (ImageView) findViewById(R.id.imageBack);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(AwareActivity.this,MenuActivity.class));
                finish();
            }
        });

        imageLogout = (ImageView) findViewById(R.id.imageLogout);
        imageLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AssistTransactionActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(AssistTransactionActivity.this, LoginActivity.class);

                        ij.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ij.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        ij.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        ij.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                        startActivity(ij);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();
                //startActivity(new Intent(AwareActivity.this, MenuActivity.class));
            }
        });
    }
}
