package com.swishmock.app.controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.swishmock.app.model.Payment;
import com.swishmock.app.view.View;

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
	public void propertyChange(PropertyChangeEvent e) {
		// This method gets called when a bound property is changed (from doc on
		// PropertyChangeListener)

		System.out.println("A bound property were changed: " + e.getPropertyName()); // Debug

		// If a property gets a new value not by the view, but by a phone book service
		// or a calculator service, it's important this change on the model is reflected
		// in the view
		view.modelPropertyChange(e);
	}

	@Override
	public void onTargetViewEvent(String newTarget) {
		// When an action happens in the view, the affected property gets updated
		// In this case the target value comes from the view
		model.setTarget(newTarget);

		// TODO: Validation so the setTarget is called only if it's a valid phone number
	}

	@Override
	public void onAmountViewEvent(double newAmount) {
		// When an action happens in the view, the affected property gets updated
		model.setAmount(newAmount);

		// TODO: Validation so the setAmount is called only if it's a valid amount
	}

	@Override
	public void onViewEvent(ActionEvent e) {
		System.out.println("Action command: " + e.getActionCommand()); // Debug

		if (e.getActionCommand().equals("Phone book")) {
			// In this case the target value comes from a phone book service, not the view
			// Therefore, it will be the model property change that will update the view
			model.setTarget("0702223344");
		} else if (e.getActionCommand().equals("Swish")) {
			// Call repository method
			System.out.println("Sends payment");
		}
	}

}
