package com.swishmock.app;

import javax.swing.SwingUtilities;

import com.swishmock.view.PaymentView;

public class Application implements Runnable {
	public void run() {
		new PaymentView();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Application());
	}
}
