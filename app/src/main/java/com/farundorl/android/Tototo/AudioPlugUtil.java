package com.farundorl.android.Tototo;

import android.content.Context;
import android.media.AudioManager;

/**
 * オーディオ機器接続状態のUtil
 */
public class AudioPlugUtil {
    public static boolean isPlugged(Context context) {
        AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (audio.isBluetoothA2dpOn()) {
            // Adjust output for Bluetooth.
            return true;
        } else if (audio.isSpeakerphoneOn()) {
            // Adjust output for Speakerphone.
            return true;
        } else if (audio.isWiredHeadsetOn()) {
            // Adjust output for headsets
            return true;
        } else {
            // If audio plays and noone can hear it, is it still playing?
            return false;
        }
    }
}