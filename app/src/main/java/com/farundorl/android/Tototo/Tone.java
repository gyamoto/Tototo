package com.farundorl.android.Tototo;

import android.media.ToneGenerator;
import android.support.annotation.Nullable;

/**
 * 16種類のTone
 */
public enum Tone {
    TONE_1(R.id.fab_1, ToneGenerator.TONE_DTMF_0),
    TONE_2(R.id.fab_2, ToneGenerator.TONE_DTMF_1),
    TONE_3(R.id.fab_3, ToneGenerator.TONE_DTMF_2),
    TONE_4(R.id.fab_4, ToneGenerator.TONE_DTMF_3),
    TONE_5(R.id.fab_5, ToneGenerator.TONE_DTMF_4),
    TONE_6(R.id.fab_6, ToneGenerator.TONE_DTMF_5),
    TONE_7(R.id.fab_7, ToneGenerator.TONE_DTMF_6),
    TONE_8(R.id.fab_8, ToneGenerator.TONE_DTMF_7),
    TONE_9(R.id.fab_9, ToneGenerator.TONE_DTMF_8),
    TONE_10(R.id.fab_10, ToneGenerator.TONE_DTMF_9),
    TONE_11(R.id.fab_11, ToneGenerator.TONE_DTMF_A),
    TONE_12(R.id.fab_12, ToneGenerator.TONE_DTMF_B),
    TONE_13(R.id.fab_13, ToneGenerator.TONE_DTMF_C),
    TONE_14(R.id.fab_14, ToneGenerator.TONE_DTMF_D),
    TONE_15(R.id.fab_15, ToneGenerator.TONE_DTMF_P),
    TONE_16(R.id.fab_16, ToneGenerator.TONE_DTMF_S);

    public int viewId;
    public int toneType;

    Tone(int viewId, int toneType) {
        this.viewId = viewId;
        this.toneType = toneType;
    }

    @Nullable
    public static Tone valueOf(int viewId) {
        for (Tone tone : values()) {
            if (tone.viewId == viewId) return tone;
        }
        return null;
    }

}
