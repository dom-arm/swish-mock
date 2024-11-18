package com.swishmock.app;

import javax.swing.SwingUtilities;

import com.swishmock.app.controller.PaymentController;
import com.swishmock.app.model.Payment;
import com.swishmock.app.view.PaymentView;

public class Application implements Runnable {
	public void run() {
		PaymentView paymentView = new PaymentView();
		Payment paymentModel = new Payment();
		PaymentController paymentController = new PaymentController(paymentView, paymentModel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Application());
	}
}
