package com.gary.firebase.admob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gary.firebase.R;
import com.gary.firebase.admob.callback.AdListenerImpl;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * Created by GaryCao on 2018/11/16.
 *
 * Admob 横幅广告单元显示
 */
public class BannerAdActivity extends AppCompatActivity {
    private AdView mAdView;
    private AdListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_banner);
        initAdMob();
    }

    private void initAdMob(){
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, getString(R.string.admob_app_id));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mListener = new AdListenerImpl();
        mAdView.setAdListener(mListener);
    }
}
