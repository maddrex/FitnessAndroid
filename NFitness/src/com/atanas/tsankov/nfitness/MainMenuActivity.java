package com.atanas.tsankov.nfitness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_screen_layout);
		Button startWorkoutButton = (Button) findViewById(R.id.start_workout_button);
		Button setProgrammeButton = (Button) findViewById(R.id.set_programme_button);
		setProgrammeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainMenuActivity.this, SetProgrammeActivity.class));
			}
		});
		startWorkoutButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainMenuActivity.this, PickWorkoutActivity.class));
			}
		});
	}
}
