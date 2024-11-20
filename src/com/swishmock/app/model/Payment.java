package com.swishmock.app.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Payment {
	private PropertyChangeSupport propertyChangeSupport;

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.propertyChangeSupport.addPropertyChangeListener(listener);
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
		return this.amount;
	}

	public void setAmount(double newAmount) {
		double oldAmount = this.amount;
		this.amount = newAmount;
		this.propertyChangeSupport.firePropertyChange("amount", oldAmount, newAmount);
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String newTarget) {
		String oldTarget = this.target;
		this.target = newTarget;
		this.propertyChangeSupport.firePropertyChange("target", oldTarget, newTarget);
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String newMessage) {
		String oldMessage = this.message;
		this.message = newMessage;
		this.propertyChangeSupport.firePropertyChange("message", oldMessage, newMessage);
	}
}
