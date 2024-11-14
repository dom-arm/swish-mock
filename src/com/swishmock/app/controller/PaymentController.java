package com.swishmock.app.controller;

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
	public void onPhoneBookViewEvent() {
		System.out.println("Pressed the phone book"); // Debug

		// In this case the target value comes from a phone book service, not the view
		// Therefore, it will be the model property change that will update the view
		String newTarget = "0702223344";
		model.setTarget(newTarget);

		// TODO: Validation on phone number from the phone book service
	}

	@Override
	public void onAmountViewEvent(double newAmount) {
		// When an action happens in the view, the affected property gets updated
		model.setAmount(newAmount);

		// TODO: Validation so the setAmount is called only if it's a valid amount
	}

	@Override
	public void onSubmitViewEvent() {
		// Call a repository method

		System.out.println("Submitted payment"); // Debug
	}

}
