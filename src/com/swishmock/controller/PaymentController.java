package com.swishmock.controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.swishmock.model.Payment;
import com.swishmock.view.View;

public class PaymentController implements ViewListener, PropertyChangeListener {

	private final View view;
	private final Payment model;

	public PaymentController(View view, Payment model) {
		view.registerViewListener(this);
		model.addPropertyChangeListener(this);

		this.view = view;
		this.model = model;
	}

	@Override
	public void onViewEvent(ActionEvent e) {
		System.out.println("In PCont " + e.getActionCommand()); // Debug

		if (e.getActionCommand().equals("Phone book")) {
			// Call PhoneBookService method, which returns target
			this.changeTarget("0702223344");
		} else if (e.getActionCommand().equals("Swish")) {
			// Call repository method
			System.out.println("Sends payment");
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		view.modelPropertyChange(e);
	}

	private void changeTarget(String newTarget) {
		model.setTarget(newTarget);
	}
}
