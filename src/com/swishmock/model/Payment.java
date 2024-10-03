package com.swishmock.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Payment {
	private double amount;
	private String target;
	private String message;

	private final PropertyChangeSupport propertyChangeSupport;

	public Payment() {
		this.propertyChangeSupport = new PropertyChangeSupport(this);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
}
