package com.swishmock.app;

import javax.swing.SwingUtilities;

import com.swishmock.controller.PaymentController;
import com.swishmock.model.Payment;
import com.swishmock.view.PaymentView;
import com.swishmock.view.View;

public class Application implements Runnable {
	public void run() {
		View paymentView = new PaymentView();
		Payment paymentModel = new Payment();
		PaymentController paymentController = new PaymentController(paymentView, paymentModel);

		paymentView.render();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Application());
	}
}
