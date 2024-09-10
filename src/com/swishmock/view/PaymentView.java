package com.swishmock.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PaymentView {

	public PaymentView() {
		initComponents();
	}

	private void initComponents() {
		JFrame frame = new JFrame("Swish mock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel inputPanel = createInputPanel();
		JPanel buttonPanel = createButtonPanel();

		frame.add(inputPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
	}

	private JPanel createInputPanel() {
		JPanel inputPanel = new JPanel(new GridLayout(6, 2));

		// Recipient
		JLabel recipientLabel = new JLabel("Recipient:");
		JTextField recipientField = new JTextField();
		JButton selectRecipientButton = new JButton("Phone book");

		inputPanel.add(recipientLabel);
		inputPanel.add(new JLabel()); // Empty cells to align components in the grid, maybe later use GridBagLayout?
		inputPanel.add(recipientField);
		inputPanel.add(selectRecipientButton);

		// Amount
		JLabel amountLabel = new JLabel("Amount:");
		JTextField amountField = new JTextField();

		inputPanel.add(amountLabel);
		inputPanel.add(new JLabel());
		inputPanel.add(amountField);
		inputPanel.add(new JLabel());

		// Message
		JLabel messageLabel = new JLabel("Message:");
		JTextArea messageArea = new JTextArea();
		messageArea.setLineWrap(true);
		messageArea.setWrapStyleWord(true);

		inputPanel.add(messageLabel);
		inputPanel.add(new JLabel());
		inputPanel.add(new JScrollPane(messageArea));
		inputPanel.add(new JLabel());

		return inputPanel;
	}

	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel(new BorderLayout()); // Use default FlowLayout if want centred button instead
		JButton submitButton = new JButton("Swish");
		buttonPanel.add(submitButton); // Add WEST or EAST to push button to either sides

		return buttonPanel;
	}
}
