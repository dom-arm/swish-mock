package com.swishmock.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;

public interface ViewListener {
	public void onActionPerformed(ActionEvent evt);

	public void onFocusLost(FocusEvent evt);
}
