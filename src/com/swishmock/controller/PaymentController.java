package com.swishmock.controller;

import java.awt.event.ActionEvent;

import com.swishmock.view.View;

public class PaymentController implements ViewListener {

	public PaymentController(View view) {
		view.registerViewListener(this);
		view.initEventListening();
	}

	@Override
	public void onViewEvent(ActionEvent e) {
		// Phone, amount and message has to be sent to the model
		System.out.println("Pressed " + e);
	}
}
