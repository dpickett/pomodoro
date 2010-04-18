package com.enlightsolutions.pomodoro.models;

import java.util.ArrayList;

import android.os.CountDownTimer;

import com.enlightsolutions.pomodoro.activities.TickHandler;

public class Timer extends CountDownTimer  {

	private Long initialSeconds;
	private Long secondsRemaining;
	private ArrayList<TickHandler> tickHandlers;
	
	public Timer(Long myInitialSeconds) {
		super(myInitialSeconds * 1000, 1000);
		initialSeconds = myInitialSeconds;
		secondsRemaining = initialSeconds;
		tickHandlers = new ArrayList<TickHandler>();
	}
	
	public Long getSecondsRemaining(){
		return secondsRemaining % 60;
	}
	
	public Long getMinutesRemaining(){
		return secondsRemaining / 60;
	}
	
	public String toString() {
		return padInt(getMinutesRemaining()) + ":" + padInt(getSecondsRemaining());
	}
	
	public void setOnTickListener(TickHandler t){
		tickHandlers.add(t);
	}
	
	private String padInt(Long i) {
		if(i >= 10){
			return i.toString();
		}
		else {
			return "0" + i.toString();
		}
	}

	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTick(long millisUntilFinished) {
		secondsRemaining = millisUntilFinished / 1000;
		tickHandlers.get(0).onTick(this);
	}		
}
