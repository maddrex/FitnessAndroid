package com.atanas.tsankov.nfitness.holders;

import android.widget.ImageView;
import android.widget.TextView;

public class SetProgrammeHolder {

	private TextView nameView;
	private ImageView closeButton;

	public ImageView getCloseButton() {
		return closeButton;
	}

	public void setCloseButton(ImageView closeButton) {
		this.closeButton = closeButton;
	}

	public TextView getNameView() {
		return nameView;
	}

	public void setNameView(TextView nameView) {
		this.nameView = nameView;
	}

}
