package com.appzeto.status;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.appzeto.status.utils.AdManager;
import com.appzeto.status.utils.Utils;


public class YoutubeActivity extends AppCompatActivity {
    ImageView backBtn;
    LinearLayout instaBtn;

    EditText linkEdt;
    TextView downloadBtn;
    ImageView help1, help2, help3, help4, help5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        help1 = findViewById(R.id.help1);
        help2 = findViewById(R.id.help2);
        help3 = findViewById(R.id.help3);
        help4 = findViewById(R.id.help4);
        help5 = findViewById(R.id.help5);

        Glide.with(YoutubeActivity.this)
                .load(ContextCompat.getDrawable(this,R.drawable.youtube))
                .into(help1);

        Glide.with(YoutubeActivity.this)
                .load(R.drawable.youtube_intro01)
                .into(help2);

        Glide.with(YoutubeActivity.this)
                .load(R.drawable.youtube_intro2)
                .into(help3);

        Glide.with(YoutubeActivity.this)
                .load(ContextCompat.getDrawable(this,R.drawable.intro04))
                .into(help4);

        Glide.with(YoutubeActivity.this)
                .load(ContextCompat.getDrawable(this,R.drawable.youtube_intro03))
                .into(help5);


        linkEdt = findViewById(R.id.linkEdt);
        downloadBtn = findViewById(R.id.downloadBtn);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.isNetworkAvailable(YoutubeActivity.this)) {
                    if (linkEdt.getText().toString().trim().length() == 0) {
                        Toast.makeText(YoutubeActivity.this, "Please paste url and download!!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        final String url = linkEdt.getText().toString();

                        if (!Patterns.WEB_URL.matcher(url).matches() && !url.contains("youtu")) {
                            Toast.makeText(YoutubeActivity.this, R.string.invalid, Toast.LENGTH_SHORT).show();
                        } else {
//                            downloadYoutubeVideo(url);
                            linkEdt.getText().clear();
                        }

                        //ads
                        if (!AdManager.isloadFbAd) {
                            AdManager.adCounter++;
                            AdManager.showInterAd(YoutubeActivity.this, null);
                        } else {
                            AdManager.adCounter++;
                            AdManager.showMaxInterstitial(YoutubeActivity.this, null);
                        }
                    }
                } else {
                    Toast.makeText(YoutubeActivity.this, "Internet Connection not available!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });




        instaBtn = findViewById(R.id.youtubeIcon);
        instaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchYoutube();
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
            AdManager.initAd(YoutubeActivity.this);
            AdManager.loadBannerAd(YoutubeActivity.this, adContainer);
            AdManager.adptiveBannerAd(YoutubeActivity.this, adaptiveAdContainer);
        } else {
            //MAX + Fb banner Ads
            AdManager.initMAX(YoutubeActivity.this);
            AdManager.maxBannerAdaptive(YoutubeActivity.this, adaptiveAdContainer);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void launchYoutube() {
        String youtubeApp = "com.google.android.youtube";
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(youtubeApp);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), R.string.youtube_not_found, Toast.LENGTH_SHORT).show();
        }
    }

//    void downloadYoutubeVideo(String videoUrl) {
//        new YouTubeExtractor(this) {
//            @Override
//            public void onExtractionComplete(SparseArray<YtFile> ytFiles, VideoMeta vMeta) {
//                if (ytFiles != null) {
//                    int itag = 22;
//                    String downloadUrl = ytFiles.get(itag).getUrl();
//                }
//            }
//        }.extract(youtubeLink);
//    }
}
