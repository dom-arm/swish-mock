package com.swishmock.app.controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTextField;

import com.swishmock.app.model.Payment;
import com.swishmock.app.view.PaymentView;

public class PaymentController implements PropertyChangeListener, ViewListener {

	private final PaymentView view;
	private final Payment model;

	public PaymentController(PaymentView view, Payment model) {
		model.addPropertyChangeListener(this);
		this.model = model;

		view.setViewListener(this);
		this.view = view;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// This method gets called when a bound property is changed (from doc on
		// PropertyChangeListener)

		System.out.println("A bound property were changed: " + evt.getPropertyName()); // Debug

		// If a property gets a new value not by the input fields in the view, but by a
		// phone book service or a calculator service, it's important this change on the
		// model is reflected in the view

//		view.modelPropertyChange(evt);

		// BUG: Cannot use the source for the check, must be the property name, as of
		// now the fieldTarget is not updated in the view
		// FIX: to not hard code property names, I may add separate Property change
		// listeners to properties in the model, and then get all listeners here and
		// loop through and compare the property names
		if (evt.getSource() instanceof JTextField textField) {
			String newValue = evt.getNewValue().toString();
			if (!textField.getText().equals(newValue)) {
				textField.setText(newValue);
			}
		}

	}

	@Override
	public void onActionPerformed(ActionEvent evt) {
		// When an action happens in the view, the affected property in the model gets
		// updated

		try {
			if (evt.getSource() == view.getFieldTarget()) {
				System.out.println("Input to Target:	" + view.getFieldTarget().getText());

				// TODO: Validation service so the setTarget is called only if it's a valid
				// phone number
				model.setTarget(view.getFieldTarget().getText());
			}

			else if (evt.getSource() == view.getFieldAmount()) {
				System.out.println("Input to Amount: 	" + view.getFieldAmount().getText());

				// TODO: Validation service so the setAmount is called only if it's a valid
				// amount
				// BUG: Input <digit>f or <digit>F is being accepted
				model.setAmount(Double.parseDouble(view.getFieldAmount().getText()));

			}

			else if (evt.getSource() == view.getButtonPhoneBook()) {
				System.out.println("Pressed the phone book");

				// In this case the phone book service will be invoked and return the chosen
				// phone number/target, which then will be updated in the model
				// Therefore, it will be the property change that will update the view

				// TODO: Get phone number from a service
				model.setTarget("0702223344");

				// TODO: Validation on phone number from the phone book service
			}

			else if (evt.getSource() == view.getButtonSubmit()) {
				System.out.println("Submitted payment");

				// TODO: Call a repository method
			}

			else {

				System.out.println("An unknown source: " + evt.getSource());
			}

		} catch (NumberFormatException ex) {
			System.out.println("Here only numeric types can be written. Error: " + ex.toString());
		}

	}

}
