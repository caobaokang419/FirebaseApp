package com.gary.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gary.firebase.admob.BannerAdActivity;
import com.gary.firebase.admob.InterstitialAdActivity;
import com.gary.firebase.admob.RewardedVideoAdActivity;
import com.gary.firebase.analytics.AnalyticsActivity;
import com.gary.firebase.auth.AuthChooseActivity;
import com.gary.firebase.crashreport.CrashReportActivity;
import com.gary.firebase.dynamiclinks.DynamicLinkMainActivity;
import com.gary.firebase.fcm.FcmActivity;
import com.gary.firebase.inappmessaging.InAppMsgMainActivity;
import com.gary.firebase.indexing.IndexingMainActivity;
import com.gary.firebase.invite.InviteMainActivity;
import com.gary.firebase.performance.PerformanceMainActivity;
import com.gary.firebase.remoteconfig.RemoteConfigActivity;
import com.gary.firebase.utils.FirebaseUtils;

public class FirebaseListActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bannerAdBtn;
    private Button interstitialAdBtn;
    private Button rewardedVideoAdBtn;

    private Button remoteConfigBtn;
    private Button fcmBtn;
    private Button analyticsBtn;
    private Button crashLogBtn;
    private Button authBtn;

    private Button inappmessageBtn;
    private Button inviteBtn;
    private Button dynamiclinkBtn;
    private Button indexingBtn;
    private Button performanceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_list);

        bannerAdBtn = findViewById(R.id.banner_btn);
        bannerAdBtn.setOnClickListener(this);

        interstitialAdBtn = findViewById(R.id.interstitial_btn);
        interstitialAdBtn.setOnClickListener(this);

        rewardedVideoAdBtn = findViewById(R.id.rewarded_video_btn);
        rewardedVideoAdBtn.setOnClickListener(this);

        remoteConfigBtn = findViewById(R.id.remote_config_btn);
        remoteConfigBtn.setOnClickListener(this);

        fcmBtn = findViewById(R.id.fcm_btn);
        fcmBtn.setOnClickListener(this);

        analyticsBtn = findViewById(R.id.analytics_btn);
        analyticsBtn.setOnClickListener(this);

        crashLogBtn = findViewById(R.id.crash_report_btn);
        crashLogBtn.setOnClickListener(this);

        authBtn = findViewById(R.id.auth_btn);
        authBtn.setOnClickListener(this);

        inappmessageBtn = findViewById(R.id.inappmessage_btn);
        inappmessageBtn.setOnClickListener(this);

        inviteBtn = findViewById(R.id.invite_btn);
        inviteBtn.setOnClickListener(this);

        dynamiclinkBtn = findViewById(R.id.dynamiclink_btn);
        dynamiclinkBtn.setOnClickListener(this);

        indexingBtn = findViewById(R.id.indexing_btn);
        indexingBtn.setOnClickListener(this);

        performanceBtn = findViewById(R.id.performance_btn);
        performanceBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.banner_btn:
                FirebaseUtils.startActivity(this, BannerAdActivity.class);
                break;
            case R.id.interstitial_btn:
                FirebaseUtils.startActivity(this, InterstitialAdActivity.class);
                break;
            case R.id.rewarded_video_btn:
                FirebaseUtils.startActivity(this, RewardedVideoAdActivity.class);
                break;
            case R.id.remote_config_btn:
                FirebaseUtils.startActivity(this, RemoteConfigActivity.class);
                break;
            case R.id.fcm_btn:
                FirebaseUtils.startActivity(this, FcmActivity.class);
                break;
            case R.id.analytics_btn:
                FirebaseUtils.startActivity(this, AnalyticsActivity.class);
                break;
            case R.id.crash_report_btn:
                FirebaseUtils.startActivity(this, CrashReportActivity.class);
                break;
            case R.id.auth_btn:
                FirebaseUtils.startActivity(this, AuthChooseActivity.class);
                break;
            case R.id.inappmessage_btn:
                FirebaseUtils.startActivity(this, InAppMsgMainActivity.class);
                break;
            case R.id.invite_btn:
                FirebaseUtils.startActivity(this, InviteMainActivity.class);
                break;
            case R.id.dynamiclink_btn:
                FirebaseUtils.startActivity(this, DynamicLinkMainActivity.class);
                break;
            case R.id.performance_btn:
                FirebaseUtils.startActivity(this, PerformanceMainActivity.class);
                break;
            case R.id.indexing_btn:
                FirebaseUtils.startActivity(this, /*App*/IndexingMainActivity.class);
                break;
            default:
                break;
        }
    }
}
