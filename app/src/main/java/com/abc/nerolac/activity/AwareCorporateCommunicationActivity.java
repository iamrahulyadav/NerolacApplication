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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AwareCorporateCommunicationPdfActivity;
import com.abc.nerolac.adapter.AwareAdapter;
import com.abc.nerolac.model.AwareModel;
import com.abc.nerolac.utility.Constants;

import java.util.ArrayList;

public class AwareCorporateCommunicationActivity extends AppCompatActivity {

    TextView textListViewTitle, textBack, textLogout;
    ListView listView;

    Button buttonImpressionNewsLetter, buttonCorporateCommunication;

    ArrayList<AwareModel> modelArrayList;
    AwareAdapter awareAdapter;

    TextView text1,text2,text3;

    ImageView imageHome, imageBack, imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aware_corporate);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/roboto.thin.ttf");

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AwareCorporateCommunicationActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME, null);*/

        /*textLogout = (TextView) findViewById(R.id.textLogout);
        textLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AwareCorporateCommunicationActivity.this);
                preferences.edit().clear().commit();

                startActivity(new Intent(AwareCorporateCommunicationActivity.this,LoginActivity.class));
            }
        });

        textBack = (TextView) findViewById(R.id.textBack);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

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

        modelArrayList = new ArrayList<>();
        //modelArrayList.add(new AwareModel("Impression Newsletter", R.drawable.pdf_icon));
        //modelArrayList.add(new AwareModel("Corporate Communication",R.drawable.pdf_icon));
        modelArrayList.add(new AwareModel("Other Org Circulars", R.drawable.pdf_icon));
        /*modelArrayList.add(new AwareModel("Old Impression Newsletter", R.drawable.pdf_icon));
        modelArrayList.add(new AwareModel("Old Corporate Communication", R.drawable.pdf_icon));*/

        listView = (ListView) findViewById(R.id.listView);
        awareAdapter = new AwareAdapter(this,modelArrayList);
        listView.setAdapter(awareAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AwareModel awareModel = modelArrayList.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AwareCorporateCommunicationActivity.this, AwareCorporateCommunicationPdfActivity.class);
                intent.putExtra("AwareModel", awareModel);
                startActivity(intent);

            }
        });


        buttonImpressionNewsLetter = (Button) findViewById(R.id.buttonImpressionNewsLetter);
        buttonImpressionNewsLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwareCorporateCommunicationActivity.this,AwareCorporateImpressionNewsLetterActivity.class);
                //intent.putExtra("LoginName",intentLoginName.getStringExtra("LoginName"));
                startActivity(intent);
            }
        });

        buttonCorporateCommunication = (Button) findViewById(R.id.buttonCorporateCommunication);
        buttonCorporateCommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwareCorporateCommunicationActivity.this,AwareCorporateCorporateCommunicationActivity.class);
                //intent.putExtra("LoginName",intentLoginName.getStringExtra("LoginName"));
                startActivity(intent);
            }
        });

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AwareCorporateCommunicationActivity.this,MenuActivity.class));
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

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AwareCorporateCommunicationActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent ij = new Intent(AwareCorporateCommunicationActivity.this, LoginActivity.class);

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
