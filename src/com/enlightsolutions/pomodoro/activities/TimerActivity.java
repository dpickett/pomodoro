package com.enlightsolutions.pomodoro.activities;

import com.enlightsolutions.pomodoro.R;

import com.enlightsolutions.pomodoro.models.PomodoroTimer;
import com.enlightsolutions.pomodoro.models.Timer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends Activity {
	PomodoroTimer pTimer;
	TextView timeRemaining;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);
        timeRemaining = (TextView)findViewById(R.id.timeRemaining);
        Button startTimer = (Button)findViewById(R.id.startTimer);
        Button stopTimer = (Button)findViewById(R.id.stopTimer);
        
        initializeTimer();
        startTimer.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Toast.makeText(v.getContext(), "Started", Toast.LENGTH_SHORT).show();
				pTimer.start();
			}
        });
        
        stopTimer.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(v.getContext(), "Stopped", Toast.LENGTH_SHORT).show();
				pTimer.cancel();
				initializeTimer();
			}
        });
    }
    
    private void initializeTimer(){
    	pTimer = new PomodoroTimer();
        timeRemaining.setText(pTimer.toString());
        
        pTimer.setOnTickListener(new TickHandler(){
			@Override
			public void onTick(Timer t) {
				timeRemaining.setText(t.toString());
			}
        });
    }
    
}