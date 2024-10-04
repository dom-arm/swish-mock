package com.swishmock.controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.swishmock.model.Payment;
import com.swishmock.view.View;

public class PhoneBookController implements ViewListener, PropertyChangeListener {

	private View view;
	private Payment model;

	public PhoneBookController(View view, Payment model) {
		view.registerViewListener(this);
		this.view = view;

		view.initPhoneBookBtnEventListening(); // Temporarily for solution

		model.addPropertyChangeListener(this);
		this.model = model;
	}

	public void changeTarget(String newTarget) {
		model.setTarget(newTarget);
	}

	@Override
	public void onViewEvent(ActionEvent e) {
		// The PhoneBook button is pressed
		// Interaction with the Phonebook must start
		// The logic is in the service
		this.changeTarget("0702223344");
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// When the models target property is changed, that phone number must be
		// rendered in the view's phone number text field. Need to handle that it may
		// try to update a view with a value that is the same as the current value in
		// the view already
		view.modelPropertyChange(e);
	}
}
