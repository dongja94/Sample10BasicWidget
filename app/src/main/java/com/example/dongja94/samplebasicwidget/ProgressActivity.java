package com.example.dongja94.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {

    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(10000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = -1;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    this.progress = progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                progress = -1;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (progress != -1) {
                    Toast.makeText(ProgressActivity.this, "progress : " + progress , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
