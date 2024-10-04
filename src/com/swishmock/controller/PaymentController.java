package com.swishmock.controller;

import java.awt.event.ActionEvent;

import com.swishmock.model.Payment;
import com.swishmock.view.View;

public class PaymentController implements ViewListener {

	public PaymentController(View view, Payment model) {
		view.registerViewListener(this);
	}

	@Override
	public void onViewEvent(ActionEvent e) {
		System.out.println("In PCont " + e.getActionCommand()); // Debug

		if (e.getActionCommand().equals("Swish")) {
			System.out.println("Sends payment");
		}
	}

	// Should listen to property changes on the model, and update the view
}
