package com.swishmock.app.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.swishmock.app.controller.ViewListener;

public class PaymentView implements View {

	private JFrame frame;
	private JTextField targetField;
	private JTextField amountField;
	private JTextArea messageArea;
	private JButton phoneBookBtn;
	private JButton submitBtn;

	private List<ViewListener> viewListeners = new ArrayList<ViewListener>();

	public PaymentView() {
		initComponents();
		render();
	}

	@Override
	public void registerViewListener(ViewListener viewListener) {
		this.viewListeners.add(viewListener);
		initEventListening();
	}

	@Override
	public void initEventListening() {
		phoneBookBtn.addActionListener(e -> alertListeners(e));
		submitBtn.addActionListener(e -> alertListeners(e));
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName().equals("target")) {
			String newTarget = e.getNewValue().toString();
			if (!targetField.getText().equals(newTarget)) {
				targetField.setText(newTarget);
			}
		}
	}

	private void alertListeners(ActionEvent e) {
		for (ViewListener listener : viewListeners) {
			listener.onViewEvent(e);
		}
	}

	private void initComponents() {
		this.frame = new JFrame("Swish mock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel inputPanel = createInputPanel();
		JPanel submitPanel = createSubmitPanel();

		frame.add(inputPanel, BorderLayout.CENTER);
		frame.add(submitPanel, BorderLayout.SOUTH);
	}

	private JPanel createInputPanel() {
		JPanel inputPanel = new JPanel(new GridLayout(6, 2));

		// Recipient
		JLabel recipientLabel = new JLabel("Recipient:");
		this.targetField = new JTextField();
		this.phoneBookBtn = new JButton("Phone book");

		inputPanel.add(recipientLabel);
		inputPanel.add(new JLabel()); // Empty cells to align components in the grid, maybe later use GridBagLayout?
		inputPanel.add(targetField);
		inputPanel.add(phoneBookBtn);

		// Amount
		JLabel amountLabel = new JLabel("Amount:");
		this.amountField = new JTextField();

		inputPanel.add(amountLabel);
		inputPanel.add(new JLabel());
		inputPanel.add(amountField);
		inputPanel.add(new JLabel());

		// Message
		JLabel messageLabel = new JLabel("Message:");
		this.messageArea = new JTextArea();
		this.messageArea.setLineWrap(true);
		this.messageArea.setWrapStyleWord(true);

		inputPanel.add(messageLabel);
		inputPanel.add(new JLabel());
		inputPanel.add(new JScrollPane(messageArea));
		inputPanel.add(new JLabel());

		return inputPanel;
	}

	private JPanel createSubmitPanel() {
		JPanel submitPanel = new JPanel(new BorderLayout()); // Use default FlowLayout if want centred button instead
		this.submitBtn = new JButton("Swish");
		submitPanel.add(submitBtn); // Add WEST or EAST to push button to either sides

		return submitPanel;
	}

	public void render() {
		frame.pack();
		frame.setVisible(true);
	}
}
