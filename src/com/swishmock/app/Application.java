package com.swishmock.app;

import javax.swing.SwingUtilities;

import com.swishmock.app.controller.PaymentController;
import com.swishmock.app.model.Payment;
import com.swishmock.app.view.PaymentView;
import com.swishmock.app.view.View;

public class Application implements Runnable {
	public void run() {
		View paymentView = new PaymentView();
		Payment paymentModel = new Payment();
		PaymentController paymentController = new PaymentController(paymentView, paymentModel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Application());
	}
}
