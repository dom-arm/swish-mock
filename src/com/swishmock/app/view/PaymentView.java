package com.swishmock.app.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.swishmock.app.controller.ViewListener;

public class PaymentView implements ActionListener, FocusListener {

	private JTextField fieldTarget;
	private JTextField fieldAmount;
	private JTextArea textAreaMessage;
	private JButton buttonPhoneBook;
	private JButton buttonSubmit;

	private ViewListener viewListener;

	public PaymentView() {
		JFrame frame = initComponents();
		initListeners();
		render(frame);
	}

	public JTextField getFieldTarget() {
		return this.fieldTarget;
	}

	public JTextField getFieldAmount() {
		return this.fieldAmount;
	}

	public JTextArea getTextAreaMessage() {
		return this.textAreaMessage;
	}

	public JButton getButtonPhoneBook() {
		return this.buttonPhoneBook;
	}

	public JButton getButtonSubmit() {
		return this.buttonSubmit;
	}

	public void setViewListener(ViewListener controller) {
		this.viewListener = controller;
	}

	private void initListeners() {
		fieldTarget.addActionListener(this);
		fieldAmount.addActionListener(this);
		textAreaMessage.addFocusListener(this);
		buttonPhoneBook.addActionListener(this);
		buttonSubmit.addActionListener(this);
	}

	private JFrame initComponents() {
		JFrame frame = new JFrame("Swish mock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel inputPanel = createInputPanel();
		JPanel submitPanel = createSubmitPanel();

		frame.add(inputPanel, BorderLayout.CENTER);
		frame.add(submitPanel, BorderLayout.SOUTH);

		return frame;
	}

	private JPanel createInputPanel() {
		JPanel inputPanel = new JPanel(new GridLayout(6, 2));

		// Recipient
		JLabel recipientLabel = new JLabel("Mottagare:");
		this.fieldTarget = new JTextField();
		this.buttonPhoneBook = new JButton("Telefonbok");

		inputPanel.add(recipientLabel);
		inputPanel.add(new JLabel()); // Empty cells to align components in the grid, maybe later use GridBagLayout?
		inputPanel.add(fieldTarget);
		inputPanel.add(buttonPhoneBook);

		// Amount
		JLabel amountLabel = new JLabel("Belopp:");
		this.fieldAmount = new JTextField();

		inputPanel.add(amountLabel);
		inputPanel.add(new JLabel());
		inputPanel.add(fieldAmount);
		inputPanel.add(new JLabel());

		// Message
		JLabel messageLabel = new JLabel("Meddelande:");
		this.textAreaMessage = new JTextArea();
		this.textAreaMessage.setLineWrap(true);
		this.textAreaMessage.setWrapStyleWord(true);
		this.textAreaMessage.setColumns(15);

		inputPanel.add(messageLabel);
		inputPanel.add(new JLabel());
		inputPanel.add(new JScrollPane(textAreaMessage));
		inputPanel.add(new JLabel());

		return inputPanel;
	}

	private JPanel createSubmitPanel() {
		JPanel submitPanel = new JPanel(new BorderLayout()); // Use default FlowLayout if want centred button instead
		this.buttonSubmit = new JButton("Swisha");
		submitPanel.add(buttonSubmit); // Add WEST or EAST to push button to either sides

		return submitPanel;
	}

	private void render(JFrame frame) {
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		viewListener.onActionPerformed(evt);
	}

	@Override
	public void focusGained(FocusEvent evt) {
		// Nothing yet
	}

	@Override
	public void focusLost(FocusEvent evt) {
		viewListener.onFocusLost(evt);
	}

}
