package com.farundorl.android.Tototo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * ヘッドセット接続のBroadcastReceiver
 */
public class AudioHeadsetPlugReceiver extends BroadcastReceiver {

    private AudioPlugListener listener;

    public void setListener(AudioPlugListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_HEADSET_PLUG.equals(intent.getAction())) {
            if (listener != null) {
                listener.audioChange(AudioPlugUtil.isPlugged(context));
            }
        }
    }

}
