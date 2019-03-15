package com.gary.firebase.remoteconfig;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gary.firebase.BuildConfig;
import com.gary.firebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;


/**
 * Created by GaryCao on 2018/11/16.
 * <p>
 * Firebase RemoteConfig：云配置
 */
public class RemoteConfigActivity extends AppCompatActivity {
    private static final String TAG = "RemoteConfigActivity";

    // Remote Config keys
    private static final String LOADING_PHRASE_CONFIG_KEY = "loading_phrase";
    private static final String WELCOME_MESSAGE_KEY = "welcome_message";
    private static final String WELCOME_MESSAGE_CAPS_KEY = "welcome_message_caps";
    private static final String WEATHER_UI_BG_COLOR_KEY = "weather_ui_bg_color";
    private static final String DEF_WEATHER_CITY_INFO_KEY = "def_weather_city_info";

    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private TextView mWelcomeTextView;
    private TextView mDefCityTextView;
    private TextView mDefBgColorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_remote_config);

        mWelcomeTextView = findViewById(R.id.welcomeTextView);
        mDefCityTextView = findViewById(R.id.defCityTextView);
        mDefBgColorTextView = findViewById(R.id.defBgColorTextView);

        Button fetchButton = findViewById(R.id.fetchButton);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchRemoteConfigs();
            }
        });

        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        mFirebaseRemoteConfig.setConfigSettings(configSettings);

        //Step1: 加载应用xml中默认属性值
        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);

        //Step2: 请求Remote config数据
        fetchRemoteConfigs();
    }

    private void fetchRemoteConfigs() {
        displayLocalConfigInfos();//Step3: 加载配置，刷新UI
        mFirebaseRemoteConfig.fetch(cacheExpiration)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RemoteConfigActivity.this, "Fetch Succeeded",
                                    Toast.LENGTH_SHORT).show();

                            //Step4: 获取成功后，需APP主动Set
                            mFirebaseRemoteConfig.activateFetched();
                        } else {
                            Toast.makeText(RemoteConfigActivity.this, "Fetch Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                        displayConfigInfos(); //Step5: 重新加载配置，刷新UI
                    }
                });
    }

    private void displayConfigInfos() {
        if (mFirebaseRemoteConfig.getBoolean(WELCOME_MESSAGE_CAPS_KEY)) {
            mWelcomeTextView.setAllCaps(true);
        } else {
            mWelcomeTextView.setAllCaps(false);
        }
        mWelcomeTextView.setText(mFirebaseRemoteConfig.getString(WELCOME_MESSAGE_KEY));

        String defCityInfo = mFirebaseRemoteConfig.getString(DEF_WEATHER_CITY_INFO_KEY);
        mDefCityTextView.setText(defCityInfo);

        String defBgColor = mFirebaseRemoteConfig.getString(WEATHER_UI_BG_COLOR_KEY);
        mDefBgColorTextView.setText(defBgColor);
    }
}
