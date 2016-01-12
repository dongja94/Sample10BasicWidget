package com.example.dongja94.samplebasicwidget;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView clipView;

    int[] ids = {R.drawable.sample_0, R.drawable.sample_1,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView = (ImageView)findViewById(R.id.image_sample);
        clipView = (ImageView)findViewById(R.id.image_clip);

        Button btn = (Button)findViewById(R.id.btn_change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable d = getResources().getDrawable(R.drawable.sample_1);
                imageView.setImageDrawable(d);

//                imageView.setImageResource(R.drawable.sample_1);
            }
        });
    }

    public void onClipClick(View view) {
        int level = clipView.getDrawable().getLevel();
        level += 1000;
        if (level > 10000) {
            level = 0;
        }
        clipView.getDrawable().setLevel(level);
    }
}
