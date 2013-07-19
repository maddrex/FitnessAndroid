package com.atanas.tsankov.nfitness;

import com.atanas.tsankov.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddWorkoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_workout_layout);
		final EditText addNameEditText = (EditText) findViewById(R.id.add_workout_name_edittext);
		Button saveButton = (Button) findViewById(R.id.add_workout_save_button);
		saveButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = addNameEditText.getText().toString();
				Intent returnIntent = new Intent();
				returnIntent.putExtra(Constants.NAME, name);
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}
}
