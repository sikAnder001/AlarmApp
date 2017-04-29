package com.example.sony.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private PendingIntent pi;
    ToggleButton tb;
    TimePicker tp;
    TextView tv;
    AlarmManager am;
    private static  MainActivity inst;

    public static MainActivity instance(){
    return inst;
    }

    @Override
    public void onStart(){
        super.onStart();
        inst=this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
tb=(ToggleButton)findViewById(R.id.tb);
        tv=(TextView)findViewById(R.id.alarmText);
        tp=(TimePicker) findViewById(R.id.tp);
        am=(AlarmManager)getSystemService(ALARM_SERVICE);
    }

    public void onClick(View v){
if(((ToggleButton)v).isChecked()){
Calendar calender=Calendar.getInstance();
calender.set(Calendar.HOUR_OF_DAY, tp.getCurrentHour());
    calender.set(Calendar.MINUTE,tp.getCurrentMinute());
    Intent i=new Intent(MainActivity.this,AlarmRecieve.class);
    pi = PendingIntent.getBroadcast(MainActivity.this, 0, i, 0);
am.set(AlarmManager.RTC,calender.getTimeInMillis(),pi);
}else{
     am.cancel(pi);
    setAlarmText("");
}

    }

    public void setAlarmText(String alarmText){
        tv.setText(alarmText);

    }
}
