package com.farundorl.android.Tototo;

import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.farundorl.android.Tototo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ToneHandler, AudioPlugListener {

    private PlugStatus plugStatus;
    private ToneGenerator toneGenerator;
    private AudioHeadsetPlugReceiver noisyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setToneHandler(this);
        plugStatus = new PlugStatus(AudioPlugUtil.isPlugged(this));
        binding.setPlugStatus(plugStatus);

        toneGenerator = new ToneGenerator(AudioManager.STREAM_DTMF, ToneGenerator.MAX_VOLUME);

        noisyReceiver = new AudioHeadsetPlugReceiver();
        noisyReceiver.setListener(this);
        registerReceiver(noisyReceiver, new IntentFilter(Intent.ACTION_HEADSET_PLUG));
    }

    @Override
    public void click(View view) {
        Tone tone = Tone.valueOf(view.getId());
        if (tone == null) return;
        toneGenerator.startTone(tone.toneType, 250);
        //FIXME:SeekBarの値によってトーンの長さ、大きさを変える
    }

    @Override
    protected void onDestroy() {
        toneGenerator.release();
        unregisterReceiver(noisyReceiver);
        super.onDestroy();
    }

    @Override
    public void audioChange(boolean plugged) {
        plugStatus.setPlugged(plugged);
    }
}
