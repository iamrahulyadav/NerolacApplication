package com.abc.nerolac.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
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
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AssistHelpDeskPdfActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.VideoActivity.AssistOtherVideoActivity;
import com.abc.nerolac.adapter.AssistAdapter;
import com.abc.nerolac.model.AssistModel;

import java.util.ArrayList;

public class AssistHelpDeskActivity extends AppCompatActivity {

    TextView textListViewTitle, textBack, textLogout;
    ListView listView;

    ArrayList<AssistModel> modelArrayList;
    AssistAdapter assistAdapter;

    TextView text1,text2,text3;

    ImageView imageHome, imageBack, imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_help_desk);

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

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AssistOtherActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME, null);*/

        /*textLogout = (TextView) findViewById(R.id.textLogout);
        textLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AssistOtherActivity.this);
                preferences.edit().clear().commit();

                startActivity(new Intent(AssistOtherActivity.this, LoginActivity.class));
            }
        });*/


        /*textBack = (TextView) findViewById(R.id.textBack);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        Typeface listTitleTypesafe = Typeface.createFromAsset(getAssets(),"fonts/roboto.bold.ttf");


        textListViewTitle = (TextView) findViewById(R.id.textListViewTitle);
        textListViewTitle.setText("HELP DESK");
        textListViewTitle.setTypeface(listTitleTypesafe);

        modelArrayList = new ArrayList<>();
        modelArrayList.add(new AssistModel("IT Helpdesk", R.drawable.pdf_icon));
        modelArrayList.add(new AssistModel("HR Helpdesk", R.drawable.pdf_icon));
        modelArrayList.add(new AssistModel("Commercial Helpdesk", R.drawable.pdf_icon));


        listView = (ListView) findViewById(R.id.listView);
        assistAdapter = new AssistAdapter(this,modelArrayList);
        listView.setAdapter(assistAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AssistModel assistModel = modelArrayList.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AssistHelpDeskActivity.this, AssistHelpDeskPdfActivity.class);
                intent.putExtra("AssistModel", assistModel);
                startActivity(intent);

            }
        });

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AssistHelpDeskActivity.this,MenuActivity.class));
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

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AssistHelpDeskActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(AssistHelpDeskActivity.this, LoginActivity.class);

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
