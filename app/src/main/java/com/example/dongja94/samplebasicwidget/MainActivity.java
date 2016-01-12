package com.example.dongja94.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView messageView;
    CheckBox alarmCheckView;
    RadioGroup groupView;

    boolean isForced = false;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageView = (TextView)findViewById(R.id.text_message);
        alarmCheckView = (CheckBox)findViewById(R.id.check_alarm);

        alarmCheckView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isForced) {
                    Toast.makeText(MainActivity.this, "checked changed : " + isChecked, Toast.LENGTH_SHORT).show();
                }
            }
        });

        groupView = (RadioGroup)findViewById(R.id.group_sex);
        groupView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                showSelectedRadio(checkedId);
            }
        });

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

    public void onButtonTwoClick(View view) {
//        Toast.makeText(this, "Button two click", Toast.LENGTH_SHORT).show();
        boolean isChecked = alarmCheckView.isChecked();
        Toast.makeText(this, "alarm check : " + isChecked, Toast.LENGTH_SHORT).show();
        isForced = true;
        alarmCheckView.setChecked(!isChecked);
        isForced = false;
    }

    public void onGroupSelect(View view) {
        int id = groupView.getCheckedRadioButtonId();
        showSelectedRadio(id);

        groupView.check(R.id.radio_m);
    }

    private void showSelectedRadio(int id) {
        switch (id) {
            case R.id.radio_m :
                Toast.makeText(this, "male", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_f :
                Toast.makeText(this, "female", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
