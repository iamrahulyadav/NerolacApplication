package com.abc.nerolac.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AwarePaintIndutryPdfActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AwarePricingPdfActivity1;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AwarePricingPdfActivity2;
import com.abc.nerolac.adapter.AwareAdapter;
import com.abc.nerolac.model.AwareModel;
import com.abc.nerolac.utility.Constants;

import java.util.ArrayList;

public class AwarePricingActivity extends AppCompatActivity {

    TextView textBack,textListViewTitle, textLogout;

    ListView listView1, listView2;
    TextView textListView, textListView1;

    ArrayList<AwareModel> modelArrayList1;
    ArrayList<AwareModel> modelArrayList2;

    AwareAdapter awareAdapter;

    TextView text1,text2,text3;

    ImageView imageHome, imageBack, imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aware_pricing);

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

        /*textBack = (TextView) findViewById(R.id.textBack);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AwarePricingActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME, null);*/

        /*textLogout = (TextView) findViewById(R.id.textLogout);
        textLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AwarePricingActivity.this);
                preferences.edit().clear().commit();

                startActivity(new Intent(AwarePricingActivity.this, LoginActivity.class));
            }
        });*/

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AwarePricingActivity.this,MenuActivity.class));
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

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AwarePricingActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(AwarePricingActivity.this, LoginActivity.class);

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


        textListViewTitle = (TextView) findViewById(R.id.textListViewTitle);
        textListViewTitle.setText("PRICING");

        textListView = (TextView) findViewById(R.id.textListView);
        textListView.setText("DEALER");

        textListView1 = (TextView) findViewById(R.id.textListView1);
        textListView1.setText("MARKET");

        modelArrayList1 = new ArrayList<>();
        modelArrayList1.add(new AwareModel("Base Final DNPL", R.drawable.pdf_icon));
        modelArrayList1.add(new AwareModel("Color DNPL",R.drawable.pdf_icon));
        modelArrayList1.add(new AwareModel("New Products DNPL",R.drawable.pdf_icon));
        modelArrayList1.add(new AwareModel("Soldier DNPL",R.drawable.pdf_icon));

        modelArrayList2 = new ArrayList<>();
        modelArrayList2.add(new AwareModel("Base Final MRPL",R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("Color MRPL",R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("New Products MRPL",R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("Soldier MRPL",R.drawable.pdf_icon));

        listView1 = (ListView) findViewById(R.id.listView1);
        awareAdapter = new AwareAdapter(this,modelArrayList1);
        listView1.setAdapter(awareAdapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AwareModel awareModel = modelArrayList1.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AwarePricingActivity.this, AwarePricingPdfActivity1.class);
                intent.putExtra("AwareModel", awareModel);
                startActivity(intent);

            }
        });

        listView2 = (ListView) findViewById(R.id.listView2);
        awareAdapter = new AwareAdapter(this,modelArrayList2);
        listView2.setAdapter(awareAdapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AwareModel awareModel = modelArrayList2.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AwarePricingActivity.this, AwarePricingPdfActivity2.class);
                intent.putExtra("AwareModel", awareModel);
                startActivity(intent);

            }
        });

        /*imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AwarePricingActivity.this, MenuActivity.class));
            }
        });*/
    }
}
