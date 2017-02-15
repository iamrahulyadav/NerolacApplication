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
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AwareHumanResourcePdfActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AwareHumanResourcePdfActivity1;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.AwareHumanResourcePdfActivity11;
import com.abc.nerolac.adapter.AwareAdapter;
import com.abc.nerolac.model.AwareModel;

import java.util.ArrayList;

public class AwareHumanResourseActivity extends AppCompatActivity {

    TextView textListView,textListView1, textBack, textListViewTitle, textLogout;

    ListView listView, listView1, listView2;

    ArrayList<AwareModel> modelArrayList1, modelArrayList2, modelArrayList3;
    AwareAdapter awareAdapter;

    TextView text1,text2,text3;

    ImageView imageHome, imageBack, imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aware_human_resourse);

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AwareHumanResourseActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME, null);*/

        /*textLogout = (TextView) findViewById(R.id.textLogout);
        textLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AwareHumanResourseActivity.this);
                preferences.edit().clear().commit();

                startActivity(new Intent(AwareHumanResourseActivity.this, LoginActivity.class));
            }
        });
*/
        /*textBack = (TextView) findViewById(R.id.textBack);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
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


        textListViewTitle = (TextView) findViewById(R.id.textListViewTitle);
        textListViewTitle.setText("HUMAN RESOURCES");



        textListView = (TextView) findViewById(R.id.textListView);
        textListView.setText("POLICIES");

        textListView1 = (TextView) findViewById(R.id.textListView1);
        //textListView1.setText("INDUCTION MODULE FRONTLINERS");

        modelArrayList1 = new ArrayList<>();
        modelArrayList1.add(new AwareModel("Role Understanding", R.drawable.pdf_icon));

        modelArrayList2 = new ArrayList<>();
        modelArrayList2.add(new AwareModel("Policy On Leave Rules", R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("Travel Policy", R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("Employee Mediclaim", R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("Mediclaim Policy Guideline",R.drawable.pdf_icon));
        modelArrayList2.add(new AwareModel("Guide To Claim Mediclaim",R.drawable.pdf_icon));

        /*modelArrayList3 = new ArrayList<>();
        modelArrayList3.add(new AwareModel("Module-1",R.drawable.pptx_icon));
        modelArrayList3.add(new AwareModel("Module-2",R.drawable.pptx_icon));
        modelArrayList3.add(new AwareModel("Module-3",R.drawable.pptx_icon));
        modelArrayList3.add(new AwareModel("Module-4",R.drawable.pptx_icon));
        modelArrayList3.add(new AwareModel("Module-5",R.drawable.pptx_icon));*/


        listView = (ListView) findViewById(R.id.listView);
        awareAdapter = new AwareAdapter(this,modelArrayList1);
        listView.setAdapter(awareAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AwareModel awareModel = modelArrayList1.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AwareHumanResourseActivity.this, AwareHumanResourcePdfActivity.class);
                intent.putExtra("AwareModel", awareModel);
                startActivity(intent);

            }
        });


        listView1 = (ListView) findViewById(R.id.listView1);
        awareAdapter = new AwareAdapter(this,modelArrayList2);
        listView1.setAdapter(awareAdapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AwareModel awareModel = modelArrayList2.get(position);

                //int listId = awareModel.getListId();
                //if(awareModel.getName().equalsIgnoreCase("Policy On Leave Rules") || awareModel.getName().equalsIgnoreCase("Travel Policy")
                //        || awareModel.getName().equalsIgnoreCase("Employee Mediclaim") || awareModel.getName().equalsIgnoreCase("Mediclaim Policy Guideline")) {

                Intent intent = new Intent(AwareHumanResourseActivity.this, AwareHumanResourcePdfActivity1.class);
                intent.putExtra("AwareModel", awareModel);
                    //intent.putExtra("TEXT_LIST_NAME",textListView);
                startActivity(intent);
                //}else {

                    /*Intent intent = new Intent(AwareHumanResourseActivity.this, AwareHumanResourcePdfActivity11.class);
                    intent.putExtra("AwareModel", awareModel);
                    //intent.putExtra("TEXT_LIST_NAME",textListView);
                    startActivity(intent);
*/
                //}
            }
        });

        /*listView2 = (ListView) findViewById(R.id.listView2);
        awareAdapter = new AwareAdapter(this,modelArrayList3);
        listView2.setAdapter(awareAdapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AwareModel awareModel = modelArrayList3.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(AwareHumanResourseActivity.this, AwareHumanResourcePdfActivity2.class);
                intent.putExtra("AwareModel", awareModel);
                startActivity(intent);

            }
        });*/

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AwareHumanResourseActivity.this,MenuActivity.class));
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

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(AwareHumanResourseActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(AwareHumanResourseActivity.this, LoginActivity.class);

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
