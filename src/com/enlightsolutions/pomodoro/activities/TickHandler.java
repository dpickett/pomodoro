package com.enlightsolutions.pomodoro.activities;

import com.enlightsolutions.pomodoro.models.Timer;

public interface TickHandler {
	public abstract void onTick(Timer t);
}
