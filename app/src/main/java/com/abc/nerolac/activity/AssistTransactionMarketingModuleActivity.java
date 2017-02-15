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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.VideoActivity.AssistCustomerVideoActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.VideoActivity.AssistTransactionMarketingVideoActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.VideoActivity.AssistTransactionMarketingVideoActivity1;
import com.abc.nerolac.adapter.AssistAdapter;
import com.abc.nerolac.model.AssistModel;
import com.abc.nerolac.utility.Constants;

import java.util.ArrayList;

public class AssistTransactionMarketingModuleActivity extends AppCompatActivity {

    TextView textListViewTitle, textBack, textLogout;
    ListView listView1, listView2;

    ArrayList<AssistModel> modelArrayList1, modelArrayList2;
    AssistAdapter assistAdapter;

    ImageView imageHome, imageBack, imageLogout;

    TextView text1,text2,text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_transaction_marketing_module);

        Typeface listTitleTypesafe = Typeface.createFromAsset(getAssets(),"fonts/roboto.bold.ttf");
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

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AssistTransactionMarketingModuleActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME, null);*/

        /*textLogout = (TextView) findViewById(R.id.textLogout);
        textLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AssistTransactionMarketingModuleActivity.this);
                preferences.edit().clear().commit();

                startActivity(new Intent(AssistTransactionMarketingModuleActivity.this, LoginActivity.class));
            }
        });*/

        /*textBack = (TextView) findViewById(R.id.textBack);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        textListViewTitle = (TextView) findViewById(R.id.textListViewTitle);
        textListViewTitle.setText("TRANSACTION - MARKETING MODULE");
        textListViewTitle.setTypeface(listTitleTypesafe);

        modelArrayList1 = new ArrayList<>();
        modelArrayList1.add(new AssistModel("Painter Meet (Creation of Meet)", R.drawable.video_icon));
        modelArrayList1.add(new AssistModel("Shop meets", R.drawable.video_icon));
        modelArrayList1.add(new AssistModel("Other Meets", R.drawable.video_icon));
        modelArrayList1.add(new AssistModel("Painter Meet - Editing", R.drawable.video_icon));

        modelArrayList1.add(new AssistModel("Actuals - Painter Meet", R.drawable.video_icon));

        modelArrayList1.add(new AssistModel("Shutter wall painting (Other Activity)", R.drawable.video_icon));
        modelArrayList1.add(new AssistModel("Hoarding", R.drawable.video_icon));
        modelArrayList1.add(new AssistModel("Retail Gate", R.drawable.video_icon));

        listView1 = (ListView) findViewById(R.id.listView1);
        assistAdapter = new AssistAdapter(this,modelArrayList1);
        listView1.setAdapter(assistAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AssistModel assistModel = modelArrayList1.get(position);

                if (assistModel.getName().equalsIgnoreCase("Painter Meet (Creation of Meet)") || assistModel.getName().equalsIgnoreCase("Shop meets")
                        || assistModel.getName().equalsIgnoreCase("Other Meets") || assistModel.getName().equalsIgnoreCase("Painter Meet - Editing")) {

                    //int listId = awareModel.getListId();
                    String videoName = "Meet Proposal creation";

                    Intent intent = new Intent(AssistTransactionMarketingModuleActivity.this, AssistTransactionMarketingVideoActivity.class);
                    intent.putExtra("VideoName", videoName);
                    startActivity(intent);
                } else if (assistModel.getName().equalsIgnoreCase("Actuals - Painter Meet")) {

                    String videoName = "Actuals - Painter Meet";

                    Intent intent = new Intent(AssistTransactionMarketingModuleActivity.this, AssistTransactionMarketingVideoActivity1.class);
                    intent.putExtra("VideoName", videoName);
                    startActivity(intent);

                } else {

                    String videoName = "Meet Proposal creation";

                    Intent intent = new Intent(AssistTransactionMarketingModuleActivity.this, AssistTransactionMarketingVideoActivity.class);
                    intent.putExtra("VideoName", videoName);
                    startActivity(intent);

                }
            }
        });

        modelArrayList2 = new ArrayList<>();
        modelArrayList2.add(new AssistModel("Dealer Initiative", R.drawable.video_icon));
        modelArrayList2.add(new AssistModel("Van Sales Operations", R.drawable.video_icon));
        modelArrayList2.add(new AssistModel("Dealer Scheme", R.drawable.video_icon));
        modelArrayList2.add(new AssistModel("Dealer Contest", R.drawable.video_icon));


        listView2 = (ListView) findViewById(R.id.listView2);
        assistAdapter = new AssistAdapter(this,modelArrayList2);
        listView2.setAdapter(assistAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AssistModel assistModel = modelArrayList2.get(position);

                //int listId = awareModel.getListId();

                if (assistModel.getName().equalsIgnoreCase("Dealer Initiative") || assistModel.getName().equalsIgnoreCase("Van Sales Operations")
                        || assistModel.getName().equalsIgnoreCase("Dealer Scheme") || assistModel.getName().equalsIgnoreCase("Dealer Contest")) {

                    //int listId = awareModel.getListId();
                    String videoName = "Meet Proposal creation";

                    Intent intent = new Intent(AssistTransactionMarketingModuleActivity.this, AssistTransactionMarketingVideoActivity.class);
                    intent.putExtra("VideoName", videoName);
                    startActivity(intent);
                }

            }
        });

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AssistTransactionMarketingModuleActivity.this,MenuActivity.class));
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

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AssistTransactionMarketingModuleActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(AssistTransactionMarketingModuleActivity.this, LoginActivity.class);

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
