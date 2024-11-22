package com.swishmock.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
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

	private void updateFieldIfChangedValue(JTextField textField, String newValue) {
		if (!textField.getText().equals(newValue))
			textField.setText(newValue);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// This method gets called when a bound property is changed (from doc on
		// PropertyChangeListener)

		System.out.println("A bound property was changed: " + evt.getPropertyName()); // Debug

		// If a property gets a new value not by user input in the view but by a phone
		// book service or calculator service, this change on the model must be
		// reflected in the view

		String propertyName = evt.getPropertyName();
		String newValue = evt.getNewValue().toString(); // Note: If it was a double it's now a String

		if (propertyName.equals("target")) {
			updateFieldIfChangedValue(view.getFieldTarget(), newValue);
		}
	}

	@Override
	public void onActionPerformed(ActionEvent evt) {
		// When an action happens in the view, the affected property in the model gets
		// updated

		try {
			if (evt.getSource() == view.getFieldTarget()) {
				System.out.println("Input to Target:	" + view.getFieldTarget().getText()); // Debug

				// TODO: Validation service so the setTarget is called only if it's a valid
				// phone number
				model.setTarget(view.getFieldTarget().getText());
			}

			else if (evt.getSource() == view.getFieldAmount()) {
				System.out.println("Input to Amount: 	" + view.getFieldAmount().getText()); // Debug

				// TODO: Validation service so the setAmount is called only if it's a valid
				// amount
				// BUG: Input <digit>f or <digit>F is being accepted
				model.setAmount(Double.parseDouble(view.getFieldAmount().getText()));

			}

			else if (evt.getSource() == view.getButtonPhoneBook()) {
				System.out.println("Pressed the phone book"); // Debug

				// In this case the phone book service will be invoked and return the chosen
				// phone number/target, which then will be updated in the model
				// Therefore, it will be the property change that will update the view

				// TODO: Get phone number from a service
				model.setTarget("0702223344");

				// TODO: Validation on phone number from the phone book service
			}

			else if (evt.getSource() == view.getButtonSubmit()) {
				System.out.println("Submitted payment"); // Debug

				// TODO: Call a repository method
			}

			else {

				System.out.println("An unknown source: " + evt.getSource()); // Debug
			}

		} catch (NumberFormatException ex) {
			System.out.println("Here only numeric types can be written. Error: " + ex.toString());
		}

	}

	@Override
	public void onFocusLost(FocusEvent evt) {
		if (evt.getSource() == view.getTextAreaMessage()) {
			System.out.println("Input to Message:	" + view.getTextAreaMessage().getText()); // Debug

			model.setMessage(view.getTextAreaMessage().getText());
		}
	}

}
