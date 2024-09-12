package com.swishmock.app;

import javax.swing.SwingUtilities;

import com.swishmock.controller.PaymentController;
import com.swishmock.view.PaymentView;
import com.swishmock.view.View;

public class Application implements Runnable {
	public void run() {
		View paymentView = new PaymentView();
		PaymentController paymentController = new PaymentController(paymentView);

		paymentView.render();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Application());
	}
}
