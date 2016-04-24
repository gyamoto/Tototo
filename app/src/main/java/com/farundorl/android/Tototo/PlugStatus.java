package com.farundorl.android.Tototo;

import android.databinding.ObservableBoolean;

/**
 * ヘッドセット接続状態
 */
public class PlugStatus {
    public final ObservableBoolean plugged = new ObservableBoolean();

    public PlugStatus(boolean plugged) {
        this.plugged.set(plugged);
    }

    public void setPlugged(boolean plugged) {
        this.plugged.set(plugged);
    }

}
