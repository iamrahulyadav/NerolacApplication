package com.abc.nerolac.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AwareCorporateCorporatePdfActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AwarePaintIndutryPdfActivity;
import com.abc.nerolac.adapter.AwareAdapter;
import com.abc.nerolac.model.AwareModel;

import java.util.ArrayList;

public class AwareCorporateCorporateCommunicationActivity extends AppCompatActivity {

    TextView textListViewTitle, textBack, textLogout;
    ListView listView1, listView2;

    ArrayList<AwareModel> modelArrayList1, modelArrayList2;
    AwareAdapter awareAdapter;

    TextView text1,text2,text3;

    ImageView imageHome, imageBack, imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aware_corporate_corporate_communication);

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AwarePaintIndustryActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME, null);

        textUserName = (TextView) findViewById(R.id.textUserName);
        //textUserName.setTypeface(typeface);
        textUserName.setText(userName);*/

        /*textLogout = (TextView) findViewById(R.id.textLogout);
        textLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AwarePaintIndustryActivity.this);
                preferences.edit().clear().commit();

                startActivity(new Intent(AwarePaintIndustryActivity.this,LoginActivity.class));
            }
        });*/

//        textBack = (TextView) findViewById(R.id.textBack);
//        textBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

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

        textListViewTitle = (TextView) findViewById(R.id.textListViewTitle);
        textListViewTitle.setText("CORPORATE COMMUNICATION");
        textListViewTitle.setTypeface(listTitleTypesafe);

        modelArrayList1 = new ArrayList<>();
        modelArrayList1.add(new AwareModel("January", R.drawable.pdf_icon));
        modelArrayList1.add(new AwareModel("February", R.drawable.pdf_icon));
        modelArrayList1.add(new AwareModel("March", R.drawable.pdf_icon));
        modelArrayList1.add(new AwareModel("April", R.drawable.pdf_icon));
        modelArrayList1.add(new AwareModel("May", R.drawable.pdf_icon));
        modelArrayList1.add(new AwareModel("June", R.drawable.pdf_icon));

        listView1 = (ListView) findViewById(R.id.listView1);
        awareAdapter = new AwareAdapter(this,modelArrayList1);
        listView1.setAdapter(awareAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AwareModel awareModel = modelArrayList1.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AwareCorporateCorporateCommunicationActivity.this, AwareCorporateCorporatePdfActivity.class);
                intent.putExtra("AwareModel", awareModel);
                startActivity(intent);

            }
        });

        modelArrayList2 = new ArrayList<>();
        modelArrayList2.add(new AwareModel("July", R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("August", R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("September", R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("October", R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("November", R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("December", R.drawable.pdf_icon));

        listView2 = (ListView) findViewById(R.id.listView2);
        awareAdapter = new AwareAdapter(this,modelArrayList2);
        listView2.setAdapter(awareAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AwareModel awareModel = modelArrayList2.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AwareCorporateCorporateCommunicationActivity.this, AwareCorporateCorporatePdfActivity.class);
                intent.putExtra("AwareModel", awareModel);
                startActivity(intent);

            }
        });

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AwareCorporateCorporateCommunicationActivity.this,MenuActivity.class));
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

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AwareCorporateCorporateCommunicationActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(AwareCorporateCorporateCommunicationActivity.this, LoginActivity.class);

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
