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
		model.addPropertyChangeListener(this);

		this.view = view;
		this.model = model;
	}

	private void changeTarget(String newTarget) {
		model.setTarget(newTarget);
	}

	@Override
	public void onViewEvent(ActionEvent e) {
		System.out.println("In PBCont " + e.getActionCommand()); // Debug

		if (e.getActionCommand().equals("Phone book")) {

			// Interaction with the Phonebook must start
			// The logic is in the service later, which returns the chosen target?
			this.changeTarget("0702223344");
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// When the models target property is changed, that phone number must be
		// rendered in the view's phone number text field
		view.modelPropertyChange(e);
	}
}
