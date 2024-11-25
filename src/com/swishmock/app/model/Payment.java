package com.swishmock.app.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Payment {
	private PropertyChangeSupport propertyChangeSupport;

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	private double amount;
	private String target;
	private String message;

	public Payment() {
	}

	public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
		this.propertyChangeSupport = propertyChangeSupport;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double newAmount) {
		double oldAmount = this.amount;
		this.amount = newAmount;
		propertyChangeSupport.firePropertyChange("amount", oldAmount, newAmount);
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String newTarget) {
		String oldTarget = this.target;
		this.target = newTarget;
		propertyChangeSupport.firePropertyChange("target", oldTarget, newTarget);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String newMessage) {
		String oldMessage = this.message;
		this.message = newMessage;
		propertyChangeSupport.firePropertyChange("message", oldMessage, newMessage);
	}
}
