package com.example.dongja94.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messageView;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageView = (TextView)findViewById(R.id.text_message);
        Button btn = (Button)findViewById(R.id.btn_change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String message = getResources().getString(R.string.text_test);
//                messageView.setText(message);
//                messageView.setText(R.string.text_test);
//                count = 5;
//                messageView.setText(""+count);
                String message = getResources().getString(R.string.text_html);
                messageView.setText(Html.fromHtml(message));
            }
        });
    }
}
