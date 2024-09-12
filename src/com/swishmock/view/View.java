package com.swishmock.view;

import com.swishmock.controller.ViewListener;

public interface View {
	public void registerViewListener(ViewListener viewListener);

	public void initEventListening();

	public void render();
}
