package com.swishmock.model;

public class Payment {
	private double amount;
	private String target;
	private String message;

	// TODO: When a phone number is chosen in the phone book, the model has to be
	// updated, and on this model property change the view in turn has to be updated

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
}
