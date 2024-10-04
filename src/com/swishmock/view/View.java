package com.swishmock.view;

import java.beans.PropertyChangeEvent;

import com.swishmock.controller.ViewListener;

public interface View {
	public void registerViewListener(ViewListener viewListener);

	public void initEventListening();

	public void initPhoneBookBtnEventListening(); // Temporarily for solution

	public void modelPropertyChange(PropertyChangeEvent e);

	public void render();
}
