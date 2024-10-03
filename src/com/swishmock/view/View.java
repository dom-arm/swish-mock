package com.swishmock.view;

import java.beans.PropertyChangeEvent;

import com.swishmock.controller.ViewListener;

public interface View {
	public void registerViewListener(ViewListener listener);

	public void initEventListening();

	public void modelPropertyChange(PropertyChangeEvent e);
}
