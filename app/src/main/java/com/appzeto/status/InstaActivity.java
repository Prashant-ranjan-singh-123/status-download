package com.appzeto.status;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.appzeto.status.insatdownload.InstaPref;
import com.appzeto.status.insatdownload.LoginActivity;
import com.appzeto.status.utils.AdManager;
import com.appzeto.status.utils.InstaDownload;
import com.appzeto.status.utils.Utils;

public class InstaActivity extends AppCompatActivity {
    ImageView backBtn;
    LinearLayout instaBtn;

    EditText linkEdt;
    TextView downloadBtn;
    ImageView help1, help2, help3, help4;
    RelativeLayout RLLoginInstagram;
    private SwitchCompat SwitchLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insta);

        SwitchLogin = findViewById(R.id.SwitchLogin);
        RLLoginInstagram = findViewById(R.id.RLLoginInstagram);

        help1 = findViewById(R.id.help1);
        help2 = findViewById(R.id.help2);
        help3 = findViewById(R.id.help3);
        help4 = findViewById(R.id.help4);

        Glide.with(InstaActivity.this)
                .load(ContextCompat.getDrawable(this,R.drawable.intro01))
                .into(help1);

        Glide.with(InstaActivity.this)
                .load(R.drawable.intro02)
                .into(help2);

        Glide.with(InstaActivity.this)
                .load(R.drawable.intro03)
                .into(help3);

        Glide.with(InstaActivity.this)
                .load(ContextCompat.getDrawable(this,R.drawable.intro04))
                .into(help4);

        SwitchLogin.setChecked(InstaPref.getInstance(this).getBoolean(InstaPref.ISINSTALOGIN));

        linkEdt = findViewById(R.id.linkEdt);
        downloadBtn = findViewById(R.id.downloadBtn);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.isNetworkAvailable(InstaActivity.this)) {
                    if (linkEdt.getText().toString().trim().length() == 0) {
                        Toast.makeText(InstaActivity.this, "Please paste url and download!!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        final String url = linkEdt.getText().toString();

                        if (!Patterns.WEB_URL.matcher(url).matches() && !url.contains("instagram")) {
                            Toast.makeText(InstaActivity.this, R.string.invalid, Toast.LENGTH_SHORT).show();
                        } else {
                            InstaDownload.INSTANCE.startInstaDownload(url, InstaActivity.this);
                            linkEdt.getText().clear();
                        }

                        //ads
                        if (!AdManager.isloadFbAd) {
                            AdManager.adCounter++;
                            AdManager.showInterAd(InstaActivity.this, null);
                        } else {
                            AdManager.adCounter++;
                            AdManager.showMaxInterstitial(InstaActivity.this, null);
                        }
                    }
                }else {
                    Toast.makeText(InstaActivity.this, "Internet Connection not available!!!!", Toast.LENGTH_SHORT).show();
                }
            }


        });



        RLLoginInstagram.setOnClickListener(v -> {
            if (!InstaPref.getInstance(this).getBoolean(InstaPref.ISINSTALOGIN)) {
                Intent intent = new Intent(this,
                        LoginActivity.class);
                activityResultLauncher.launch(intent);
            } else {
                AlertDialog.Builder ab = new AlertDialog.Builder(this);
                ab.setPositiveButton(getResources().getString(R.string.yes), (dialog, id) -> {
                    InstaPref.getInstance(this).putBoolean(InstaPref.ISINSTALOGIN, false);
                    InstaPref.getInstance(this).putString(InstaPref.COOKIES, "");
                    InstaPref.getInstance(this).putString(InstaPref.CSRF, "");
                    InstaPref.getInstance(this).putString(InstaPref.SESSIONID, "");
                    InstaPref.getInstance(this).putString(InstaPref.USERID, "");

                    SwitchLogin.setChecked(InstaPref.getInstance(this).getBoolean(InstaPref.ISINSTALOGIN));
                    dialog.cancel();

                });
                ab.setNegativeButton(getResources().getString(R.string.cancel), (dialog, id) -> dialog.cancel());
                AlertDialog alert = ab.create();
                alert.setTitle(getResources().getString(R.string.do_u_want_to_download_media_from_pvt));
                alert.show();
            }

        });


        instaBtn = findViewById(R.id.instaBtn);
        instaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchInstagram();


            }
        });

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        LinearLayout adContainer = findViewById(R.id.banner_container);
        LinearLayout adaptiveAdContainer = findViewById(R.id.banner_adaptive_container);
        if (!AdManager.isloadFbAd) {
            //admob
            AdManager.initAd(InstaActivity.this);
            AdManager.loadBannerAd(InstaActivity.this, adContainer);
            AdManager.adptiveBannerAd(InstaActivity.this, adaptiveAdContainer);
        } else {
            //MAX + Fb banner Ads
            AdManager.initMAX(InstaActivity.this);
            AdManager.maxBannerAdaptive(InstaActivity.this, adaptiveAdContainer);
        }

    }


    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        SwitchLogin.setChecked(InstaPref.getInstance(InstaActivity.this).getBoolean(InstaPref.ISINSTALOGIN));
                    }
                }
            });



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void launchInstagram() {
        String instagramApp = "com.instagram.android";
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(instagramApp);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), R.string.instagram_not_found, Toast.LENGTH_SHORT).show();
        }
    }



}
