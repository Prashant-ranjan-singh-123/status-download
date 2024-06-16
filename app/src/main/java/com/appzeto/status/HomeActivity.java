package com.appzeto.status;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.appzeto.status.printress.PinterestActivity;
import com.appzeto.status.utils.AdManager;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout wsBtn, waBusiBtn, insBtn, youtubeBtn ,tokBtn, fbBtn, tweatBtn, galBtn, vimeoBtn,
            likeeBtn, snackBtn, sChatBtn, mojBtn, roposoBtn, chingariBtn, mxBtn, mitronBtn, ziliBtn,pinBtn;
    ImageView settings;

    String[] permissionsList = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};


    String[] permissionsList13 = new String[]{Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.READ_MEDIA_VIDEO};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        LinearLayout adContainer = findViewById(R.id.banner_container);

        if (!AdManager.isloadFbAd) {
            //admob
            AdManager.initAd(HomeActivity.this);
            AdManager.loadBannerAd(HomeActivity.this, adContainer);
            AdManager.loadInterAd(HomeActivity.this);
        } else {
            //MAX + Fb banner Ads
            AdManager.initMAX(HomeActivity.this);
            AdManager.maxBanner(HomeActivity.this, adContainer);
            AdManager.maxInterstital(HomeActivity.this);
        }


    }


    void init() {
        pinBtn= findViewById(R.id.pinBtn);
        pinBtn.setOnClickListener(this);
        wsBtn = findViewById(R.id.wsBtn);
        wsBtn.setOnClickListener(this);
        waBusiBtn = findViewById(R.id.waBusiBtn);
        waBusiBtn.setOnClickListener(this);
        insBtn = findViewById(R.id.insBtn);
        insBtn.setOnClickListener(this);

//        My EDIT
//        youtubeBtn = findViewById(R.id.youtubeBtn);
//        youtubeBtn.setOnClickListener(this);
//        My Edit

        tokBtn = findViewById(R.id.tokBtn);
        tokBtn.setOnClickListener(this);
        fbBtn = findViewById(R.id.fbBtn);
        fbBtn.setOnClickListener(this);
        galBtn = findViewById(R.id.galBtn);
        galBtn.setOnClickListener(this);
        tweatBtn = findViewById(R.id.tweatBtn);
        tweatBtn.setOnClickListener(this);
        vimeoBtn = findViewById(R.id.vimeoBtn);
        vimeoBtn.setOnClickListener(this);
        likeeBtn = findViewById(R.id.likeeBtn);
        likeeBtn.setOnClickListener(this);
        snackBtn = findViewById(R.id.snackBtn);
        snackBtn.setOnClickListener(this);
        sChatBtn = findViewById(R.id.sChatBtn);
        sChatBtn.setOnClickListener(this);
        mojBtn = findViewById(R.id.mojBtn);
        mojBtn.setOnClickListener(this);
        roposoBtn = findViewById(R.id.roposoBtn);
        roposoBtn.setOnClickListener(this);
        chingariBtn = findViewById(R.id.chingariBtn);
        chingariBtn.setOnClickListener(this);
        mxBtn = findViewById(R.id.mxBtn);
        mxBtn.setOnClickListener(this);
        mitronBtn = findViewById(R.id.mitronBtn);
        mitronBtn.setOnClickListener(this);
        ziliBtn = findViewById(R.id.ziliBtn);
        ziliBtn.setOnClickListener(this);
        settings = findViewById(R.id.settings);
        settings.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.pinBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, PinterestActivity.class));
                }
                break;

            case R.id.wsBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, WAppActivity.class));
                }
                break;

            case R.id.waBusiBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, WABusiActivity.class));
                }

                break;

            case R.id.insBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, InstaActivity.class));
                }

                break;

//            case R.id.youtubeBtn:
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
//                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
//                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
//                    ActivityCompat.requestPermissions(this, permissionsList, 21);
//                } else
//                {
//                    startActivityes(new Intent(HomeActivity.this, YoutubeActivity.class));
//                }
//
//                break;

            case R.id.tokBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, TikActivity.class));
                }


                break;

            case R.id.fbBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, FBActivity.class));
                }


                break;

            case R.id.tweatBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, TwetActivity.class));
                }

                break;

            case R.id.vimeoBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, VimeoActivity.class));
                }

                break;

            case R.id.galBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, MyGalleryActivity.class));
                }

                break;

            case R.id.likeeBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, KLikeActivity.class));
                }

                break;

            case R.id.snackBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, KSnackActivity.class));
                }

                break;

            case R.id.sChatBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, SChatActivity.class));
                }

                break;

            case R.id.mojBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, KMojActivity.class));
                }

                break;

            case R.id.mxBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, KMXActivity.class));
                }



                break;

            case R.id.roposoBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, KRopoActivity.class));
                }


                break;

            case R.id.chingariBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, KChingariActivity.class));
                }

                break;

            case R.id.mitronBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, KMitroActivity.class));
                }

                break;

            case R.id.ziliBtn:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, KZiliActivity.class));
                }

                break;

            case R.id.settings:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList13)) {
                    ActivityCompat.requestPermissions(this, permissionsList13, 33);
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && !checkPermissions(this, permissionsList)) {
                    ActivityCompat.requestPermissions(this, permissionsList, 21);
                } else
                {
                    startActivityes(new Intent(HomeActivity.this, SettingsActivity.class));
                }


                break;

        }
    }

    void startActivityes(Intent intent) {
        if (!AdManager.isloadFbAd) {
            AdManager.adCounter++;
            AdManager.showInterAd(HomeActivity.this, intent);
        } else {
            AdManager.adCounter++;
            AdManager.showMaxInterstitial(HomeActivity.this, intent);
        }
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (this.doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000L);
    }


    public static boolean checkPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 21) {
            if (!checkPermissions(this, permissionsList)) {
                ActivityCompat.requestPermissions(this, permissionsList, 21);
            }
        }
        if (requestCode == 33) {
            if (!checkPermissions(this, permissionsList13)) {
                ActivityCompat.requestPermissions(this, permissionsList13, 33);
            }
        }
    }

}
