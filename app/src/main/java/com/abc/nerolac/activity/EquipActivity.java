package com.abc.nerolac.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.abc.nerolac.R;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.EquipColorOfTheYearPdfActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.EquipCompetitionComparisonPdfActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.EquipKnplProductPdfActivity;
import com.abc.nerolac.activity.HtmlPdfVedioReadingActivity.PdfActivity.EquipOtherPdfActivity;

public class EquipActivity extends AppCompatActivity {

    Button buttonShadeCards, buttonPds, buttonDealersClub;
    Button buttonMarketingResources, buttonStoreDisplaySamples;

    Button buttonKnplProduct, buttonCompetitionComparision;
    Button buttonColourOfYear, buttonOther;

    Button buttonPaint, buttonPricing, buttonPolicies;

    TextView textUserName, textBack;

    TextView text1,text2,text3;

    ImageView imageHome, imageBack, imageLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);

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
        final String loginName = intentLoginName.getStringExtra("LoginName");
*/
        /*textBack = (TextView) findViewById(R.id.textBack);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(EquipActivity.this);
        String userName = preferences.getString(Constants.LOGIN_USER_NAME,null);

        textUserName = (TextView) findViewById(R.id.textUserName);
        //textUserName.setTypeface(typeface);
        textUserName.setText(userName);*/

        imageHome = (ImageView) findViewById(R.id.imageHome);
        imageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EquipActivity.this,MenuActivity.class));
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

                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(EquipActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to logout");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ij = new Intent(EquipActivity.this, LoginActivity.class);

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

        buttonPaint = (Button) findViewById(R.id.buttonPaint);
        buttonPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this,AwarePaintIndustryActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonPricing = (Button) findViewById(R.id.buttonPricing);
        buttonPricing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this,AwarePricingActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonKnplProduct = (Button) findViewById(R.id.buttonKnplProduct);
        buttonKnplProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this, EquipKnplProductPdfActivity.class);
                String pdfName = "KNPL Products";
                intent.putExtra("KNPL_PRODUCTS", pdfName);
                startActivity(intent);
            }
        });

        buttonCompetitionComparision = (Button) findViewById(R.id.buttonCompetitionComparision);
        buttonCompetitionComparision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this, EquipCompetitionComparisonPdfActivity.class);
                String pdfName = "Competition Comparison";
                intent.putExtra("COMPETITION_COMPARISON",pdfName);
                startActivity(intent);
            }
        });

        /*buttonApplicationTechniquie = (Button) findViewById(R.id.buttonApplicationTechniquie);
        buttonApplicationTechniquie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this, EquipApplicationTechniquesPdfActivity.class);
                String pdfName = "Application Techniques";
                intent.putExtra("APPLICATION_TECHNIQUES",pdfName);
                startActivity(intent);
            }
        });*/

        /*buttonFanDecks = (Button) findViewById(R.id.buttonFanDecks);
        buttonFanDecks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this, EquipFanDecksPdfActivity.class);
                String pdfName = "Fan Decks";
                intent.putExtra("FAN_DECKS",pdfName);
                startActivity(intent);
            }
        });*/

        /*buttonMsds = (Button) findViewById(R.id.buttonMsds);
        buttonMsds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this, EquipMsdnPdfActivity.class);
                String pdfName = "MSDN";
                intent.putExtra("MSDN",pdfName);
                startActivity(intent);
            }
        });*/

        buttonColourOfYear = (Button) findViewById(R.id.buttonColourOfYear);
        buttonColourOfYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this, EquipColorOfTheYearPdfActivity.class);
                String pdfName = "Color Of The Year";
                intent.putExtra("COLOR_OF_THE_YEAR",pdfName);
                startActivity(intent);
            }
        });

        buttonOther = (Button) findViewById(R.id.buttonOther);
        buttonOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this, EquipOtherPdfActivity.class);
                String pdfName = "Others";
                intent.putExtra("OTHER",pdfName);
                startActivity(intent);
            }
        });

        buttonShadeCards = (Button) findViewById(R.id.buttonShadeCards);
        buttonShadeCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this,EquipShadeCardsActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonPds = (Button) findViewById(R.id.buttonPds);
        buttonPds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this,EquipPdsActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonDealersClub = (Button) findViewById(R.id.buttonDealersClub);
        buttonDealersClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this,EquipDealerClubActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonPolicies = (Button) findViewById(R.id.buttonPolicies);
        buttonPolicies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this,EquipPoliciesActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });


        buttonStoreDisplaySamples = (Button) findViewById(R.id.buttonStoreDisplaySamples);
        buttonStoreDisplaySamples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this,EquipStoreDisplaySampleActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });

        buttonMarketingResources = (Button) findViewById(R.id.buttonMarketingResources);
        buttonMarketingResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipActivity.this,EquipStoreMarketingResourceActivity.class);
                //intent.putExtra("LoginName",loginName);
                startActivity(intent);
            }
        });




    }
}
