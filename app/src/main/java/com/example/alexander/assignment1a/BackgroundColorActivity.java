package com.example.alexander.assignment1a;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.SeekBar;


public class BackgroundColorActivity extends SharedMenuActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seekBarHue, seekBarSaturation, seekBarValue,  seekBarAlpha;
    LinearLayout layoutColored;

    private int alpha;
    private float[] hsv = new float[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_color);

        seekBarHue = (SeekBar) findViewById(R.id.seekBarHue);
        seekBarSaturation = (SeekBar) findViewById(R.id.seekBarSaturation);
        seekBarValue = (SeekBar) findViewById(R.id.seekBarValue);
        seekBarAlpha = (SeekBar) findViewById(R.id.seekBarAlpha);

        // Sätt en lämplig lyssnare på reglagen. Den finns implementerad i denna klass.
        seekBarHue.setOnSeekBarChangeListener(this);
        seekBarSaturation.setOnSeekBarChangeListener(this);
        seekBarValue.setOnSeekBarChangeListener(this);
        seekBarAlpha.setOnSeekBarChangeListener(this);

        layoutColored = (LinearLayout) findViewById(R.id.layoutCanvas);
        // Initiera färgverdena beroende på vad reglagen är inställda
        alpha = seekBarAlpha.getProgress();
        hsv[0] = seekBarHue.getProgress();
        hsv[1] = seekBarSaturation.getProgress();
        hsv[2] = seekBarValue.getProgress();

        // Sätt en bild på själva aktivitetens bakgrund
        getWindow().getDecorView().setBackgroundResource(R.drawable.ic_launcher);
        // Sätt bakgrunds färg på layouten
        layoutColored.setBackgroundColor(Color.HSVToColor(alpha,hsv));
    }

    // Callback som skickar in reglage som används, med sitt dåvarande värde
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId())
        {
            case R.id.seekBarHue: hsv[0] = progress;
                break;
            // Anpassning från reglatets heltalsvärde till färgens flyttal
            case R.id.seekBarSaturation : hsv[1] = (float) progress / 100;
                break;
            case R.id.seekBarValue : hsv[2] = (float) progress / 100;
                break;
            case R.id.seekBarAlpha : alpha = progress;
                break;
        }
        // Uppdatera bakgrundsfärgen
        layoutColored.setBackgroundColor(Color.HSVToColor(alpha,hsv));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
