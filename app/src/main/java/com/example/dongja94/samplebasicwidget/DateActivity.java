package com.example.dongja94.samplebasicwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class DateActivity extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        datePicker.init(2016, 0, 13, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(DateActivity.this, "date : " + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth , Toast.LENGTH_SHORT).show();
            }
        });

        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setCurrentHour(10);
        timePicker.setCurrentMinute(45);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });
    }
}
