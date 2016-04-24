package com.farundorl.android.Tototo;

import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.farundorl.android.Tototo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ToneHandler {

    private ToneGenerator toneGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setToneHandler(this);
        toneGenerator = new ToneGenerator(AudioManager.STREAM_DTMF, ToneGenerator.MAX_VOLUME);
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
        super.onDestroy();
    }
}
