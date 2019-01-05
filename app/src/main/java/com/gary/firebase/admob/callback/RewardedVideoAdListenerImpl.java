package com.gary.firebase.admob.callback;

import com.gary.firebase.utils.FirebaseUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/**
 * Created by GaryCao on 2018/11/16.
 *
 * Admob 激励广告单元回调：应用实现
 */
public class RewardedVideoAdListenerImpl implements RewardedVideoAdListener{

    @Override
    public void onRewarded(RewardItem reward) {
        // TODO: 激励广告触发：此时应实现应用奖励逻辑（奖励：积分？游戏金币？）

        FirebaseUtils.showToast("onRewarded! currency: " + reward.getType() + "  amount: " + reward.getAmount());
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        FirebaseUtils.showToast("onRewardedVideoAdLeftApplication");
    }

    @Override
    public void onRewardedVideoAdClosed() {
        // TODO: 激励广告结束，可触发下一个激励广告：
        // loadRewardedVideoAd();

        FirebaseUtils.showToast("onRewardedVideoAdClosed");
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        // 激励广告加载失败（比如ID error case）
        FirebaseUtils.showToast("onRewardedVideoAdFailedToLoad");
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        FirebaseUtils.showToast("onRewardedVideoAdLoaded");
    }

    @Override
    public void onRewardedVideoAdOpened() {
        FirebaseUtils.showToast("onRewardedVideoAdLoaded");
    }

    @Override
    public void onRewardedVideoStarted() {
        FirebaseUtils.showToast("onRewardedVideoAdLoaded");
    }

    @Override
    public void onRewardedVideoCompleted() {
        FirebaseUtils.showToast("onRewardedVideoAdLoaded");
    }
}