package com.swishmock.controller;

import java.awt.event.ActionEvent;

import com.swishmock.view.View;
import com.swishmock.model.Payment;

public class PaymentController implements ViewListener {

	private Payment model;

	public PaymentController(View view, Payment model) {
		view.registerViewListener(this);
		view.initEventListening();

		this.model = model;
	}

	@Override
	public void onViewEvent(ActionEvent e) {
		// Phone, amount and message has to be sent to the model
		System.out.println("Pressed " + e);
	}
}
