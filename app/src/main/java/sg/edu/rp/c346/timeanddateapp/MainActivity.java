package sg.edu.rp.c346.timeanddateapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;

    Button btnDisplayDate, btnDisplayTime, btnReset;

    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        btnReset = findViewById(R.id.btnReset);
        tvDisplay = findViewById(R.id.editText);


        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                String message = "Time is "+ hour +":"+min;

                tvDisplay.setText(message);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Date is ";
                int day = dp.getDayOfMonth();
                int mth = dp.getMonth();
                int year = dp.getYear();

                String date = day+"/"+(mth+1)+"/"+year;
                message += date;
                tvDisplay.setText(message);
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setIs24HourView(false);
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2019,0,01);
            }
        });

    }
}
