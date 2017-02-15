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
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.EquipPdsPdfActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.EquiptShadeCardsPdfActivity;
import com.abc.nerolac.adapter.EquipAdapter;
import com.abc.nerolac.model.EquipModel;
import com.abc.nerolac.utility.Constants;

import java.util.ArrayList;

public class EquipPdsActivity extends AppCompatActivity {

    EquipAdapter equipAdapter;
    ArrayList<EquipModel> modelArrayList;

    ListView listView;

    TextView textListViewTitle, textLogout, textBack;

    TextView text1,text2,text3;

    ImageView imageHome, imageBack, imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip_pds);

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

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(EquipPdsActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME,null);*/

        /*textLogout = (TextView) findViewById(R.id.textLogout);
        textLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(EquipPdsActivity.this);
                preferences.edit().clear().commit();

                startActivity(new Intent(EquipPdsActivity.this, LoginActivity.class));
            }
        });*/

        textListViewTitle= (TextView) findViewById(R.id.textListViewTitle);
        textListViewTitle.setText("PDS");

        modelArrayList = new ArrayList<>();
        modelArrayList.add(new EquipModel("Nerolac Deco Exterior Pdts PDS", R.drawable.pdf_icon));
        modelArrayList.add(new EquipModel("Nerolac Deco Interior Pdts PDS",R.drawable.pdf_icon));
        modelArrayList.add(new EquipModel("Nerolac Excel Mica Marble PDS",R.drawable.pdf_icon));
        modelArrayList.add(new EquipModel("Nerolac Impressions Glitter PDS",R.drawable.pdf_icon));

        listView = (ListView) findViewById(R.id.listView);
        equipAdapter = new EquipAdapter(this,modelArrayList);
        listView.setAdapter(equipAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EquipModel equipModel = modelArrayList.get(position);

                //int listId = awareModel.getListId();

                Intent intent = new Intent(EquipPdsActivity.this, EquipPdsPdfActivity.class);
                intent.putExtra("EquipModel", equipModel);
                startActivity(intent);

            }
        });

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EquipPdsActivity.this,MenuActivity.class));
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

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(EquipPdsActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(EquipPdsActivity.this, LoginActivity.class);

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
