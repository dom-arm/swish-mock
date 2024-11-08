package com.swishmock.app.controller;

import java.awt.event.ActionEvent;

public interface ViewListener {
	public void onTargetViewEvent(String newTarget);

	public void onAmountViewEvent(double newAmount);

	public void onViewEvent(ActionEvent e);
}
