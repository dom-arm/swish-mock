package com.swishmock.app.controller;

public interface ViewListener {
	public void onTargetViewEvent(String newTarget);

	public void onPhoneBookViewEvent();

	public void onAmountViewEvent(double newAmount);

	public void onSubmitViewEvent();
}
