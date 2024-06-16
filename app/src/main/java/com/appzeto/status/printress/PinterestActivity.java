package com.appzeto.status.printress;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.bumptech.glide.Glide;
import com.appzeto.status.R;
import com.appzeto.status.utils.Utils;
import com.appzeto.status.workers.AllVideoDownloadWorker;
import com.yausername.youtubedl_android.YoutubeDL;
import com.yausername.youtubedl_android.YoutubeDLException;


import java.io.File;

public class PinterestActivity extends AppCompatActivity {
    ImageView backBtn;
    LinearLayout pinterestBtn;

    EditText linkEdt;
    TextView downloadBtn;
    ImageView help1, help2, help3, help4;


    private Context mContext;

    Activity mActivity;

    public static LifecycleOwner lifecycleOwner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinterest);
        lifecycleOwner = this;
        mContext = this;
        mActivity = this;

        help1 = findViewById(R.id.help1);
        help2 = findViewById(R.id.help2);
        help3 = findViewById(R.id.help3);
        help4 = findViewById(R.id.help4);


        Glide.with(PinterestActivity.this)
                .load(ContextCompat.getDrawable(this, R.drawable.pin_step_1))
                .into(help1);

        Glide.with(PinterestActivity.this)
                .load(R.drawable.pin_step_2)
                .into(help2);

        Glide.with(PinterestActivity.this)
                .load(R.drawable.pin_step_3)
                .into(help3);

        Glide.with(PinterestActivity.this)
                .load(ContextCompat.getDrawable(this, R.drawable.intro04))
                .into(help4);


        try {
            YoutubeDL.getInstance().init(this);
        } catch (YoutubeDLException e) {
            Log.e("TAG", "failed to initialize youtubedl-android", e);
        }

        linkEdt = findViewById(R.id.linkEdt);
        downloadBtn = findViewById(R.id.downloadBtn);


        downloadBtn.setOnClickListener(view -> {
            if (Utils.isNetworkAvailable(PinterestActivity.this)) {
                if (linkEdt.getText().toString().trim().length() == 0) {
                    Toast.makeText(PinterestActivity.this, "Please paste url and download!!!!", Toast.LENGTH_SHORT).show();
                } else {
                    final String url = linkEdt.getText().toString();

                    if (!url.contains("pin")) {
                        Toast.makeText(PinterestActivity.this, R.string.invalid, Toast.LENGTH_SHORT).show();
                    } else {
                        File youtubeDLDir = getDownloadLocation();
                        Data arguments = new Data.Builder().putString(AllVideoDownloadWorker.DOWNLOAD_TYPE, "videoDownload")
                                .putString(AllVideoDownloadWorker.DIRECTORY, youtubeDLDir.getAbsolutePath())
                                .putString("VIDEO_URL", url).build();


                        OneTimeWorkRequest downloaderWorkRequest = new OneTimeWorkRequest.Builder(AllVideoDownloadWorker.class)
                                .setInputData(arguments).build();
                        LiveData<WorkInfo> workInfoByIdLiveData = WorkManager.getInstance(mContext).getWorkInfoByIdLiveData(downloaderWorkRequest.getId());
                        workInfoByIdLiveData.observe(lifecycleOwner, workInfo -> {
                            if (workInfo.getState().equals(WorkInfo.State.RUNNING)) {
                                Toast.makeText(mContext, mContext.getResources().getString(R.string.dl_started), Toast.LENGTH_SHORT).show();
                                Utils.displayLoader(this);
                            }
                        });
                        WorkManager.getInstance(mContext).enqueue(downloaderWorkRequest);

                        linkEdt.setText("");
                    }

                }
            } else {
                Toast.makeText(PinterestActivity.this, "Internet Connection not available!!!!", Toast.LENGTH_SHORT).show();
            }
        });


        pinterestBtn = findViewById(R.id.instaBtn);
        pinterestBtn.setOnClickListener(v -> launchPinterest());

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> onBackPressed());



    }


    private File getDownloadLocation() {
        File downloadsDir = Utils.downloadPinDir;
        if (!downloadsDir.exists()) {
            boolean isMake = downloadsDir.mkdir();
            if (isMake) Log.v("File Create ", " Success");
        }
        return downloadsDir;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void launchPinterest() {
        String instagramApp = "com.pinterest";
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(instagramApp);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), R.string.pinterest_not_found, Toast.LENGTH_SHORT).show();
        }
    }


}


