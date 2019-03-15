package com.gary.firebase.crashreport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.crashlytics.android.Crashlytics;
import com.gary.firebase.R;


/**
 * Created by GaryCao on 2018/11/16.

 * Firebase崩溃上报
 */
public class CrashReportActivity extends AppCompatActivity {
    private static final String TAG = "AnalyticsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_crash_report);

        final CheckBox catchCrashCheckBox = findViewById(R.id.catchCrashCheckBox);
        Button crashButton = findViewById(R.id.crashButton);
        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (catchCrashCheckBox.isChecked()) {
                    try {
                        throw new NullPointerException();
                    } catch (NullPointerException ex) {
                        Crashlytics.log(Log.ERROR, TAG, "NPE caught!");
                        Crashlytics.logException(ex);
                    }
                } else {
                    throw new NullPointerException();//主动throw Exception，Firebase后台收到上报
                }
            }
        });
    }
}

