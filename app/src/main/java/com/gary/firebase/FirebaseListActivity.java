package com.gary.firebase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

import java.util.HashMap;
import java.util.Map;

public class FirebaseListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static Map<Class, String> mUIDatas = new HashMap<Class, String>();

    static {
        mUIDatas.put(BannerAdActivity.class, "Admob Banner");
        mUIDatas.put(InterstitialAdActivity.class, "Admob Interstitial");
        mUIDatas.put(RewardedVideoAdActivity.class, "Admob RewardedVideo");
        mUIDatas.put(RemoteConfigActivity.class, "Remote config");
        mUIDatas.put(FcmActivity.class, "Fcm");
        mUIDatas.put(AuthChooseActivity.class, "Auth");
        mUIDatas.put(InAppMsgMainActivity.class, "InApp msg");
        mUIDatas.put(InviteMainActivity.class, "Invite");
        mUIDatas.put(DynamicLinkMainActivity.class, "DynamicLink");
        mUIDatas.put(IndexingMainActivity.class, "Indexing");
        mUIDatas.put(PerformanceMainActivity.class, "Performance");
    }

    private static final Class[] CLASSES = new Class[]{
            /*Admob*/
            BannerAdActivity.class,
            InterstitialAdActivity.class,
            RewardedVideoAdActivity.class,

            /*Firebase funcs*/
            RemoteConfigActivity.class,
            FcmActivity.class,
            AuthChooseActivity.class,
            InAppMsgMainActivity.class,
            InviteMainActivity.class,
            DynamicLinkMainActivity.class,
            IndexingMainActivity.class,
            AnalyticsActivity.class,
            PerformanceMainActivity.class,
            CrashReportActivity.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_auth);

        // Set up ListView and Adapter
        ListView listView = findViewById(R.id.listView);

        MyArrayAdapter adapter = new MyArrayAdapter(this, android.R.layout.simple_list_item_2, CLASSES);
        //adapter.setDescriptionIds(DESCRIPTION_IDS);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class clicked = CLASSES[position];
        startActivity(new Intent(this, clicked));
    }

    public static class MyArrayAdapter extends ArrayAdapter<Class> {

        private Context mContext;
        private Class[] mClasses;
        private int[] mDescriptionIds;

        public MyArrayAdapter(Context context, int resource, Class[] objects) {
            super(context, resource, objects);

            mContext = context;
            mClasses = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(android.R.layout.simple_list_item_2, null);
            }

            ((TextView) view.findViewById(android.R.id.text1)).setText(mClasses[position].getSimpleName());
            ((TextView) view.findViewById(android.R.id.text2)).setText(mDescriptionIds[position]);

            return view;
        }

        public void setDescriptionIds(int[] descriptionIds) {
            mDescriptionIds = descriptionIds;
        }
    }
}

