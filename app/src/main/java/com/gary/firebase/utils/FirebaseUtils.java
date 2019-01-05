package com.gary.firebase.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.gary.firebase.base.MyApplication;

public class FirebaseUtils {
    public static void showToast(String msg) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void startActivity(Context context, String classname) {
        if (null != context) {
            Intent intent = new Intent();
            intent.setClassName(context, classname);
            context.startActivity(intent);
        }
    }

    public static void startActivity(Context context, Class<?> cls) {
        if (null != context) {
            context.startActivity(new Intent(context, cls));
        }
    }
}
