package com.atanas.tsankov.nfitness;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.atanas.tsankov.constants.Constants;
import com.atanas.tsankov.nfitness.adapters.SetProgrammeAdapter;
import com.atanas.tsankov.nfitness.beans.ProgrammeBean;
import com.atanas.tsankov.nfitness.beans.WorkoutBean;
import com.google.gson.Gson;

public class SetProgrammeActivity extends Activity {

	private ProgrammeBean programme = new ProgrammeBean();
	private SetProgrammeAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_programme_layout);
		Button addWorkoutButton = (Button) findViewById(R.id.set_programme_add_workout_button);
		addWorkoutButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SetProgrammeActivity.this,
						AddWorkoutActivity.class);
				startActivityForResult(intent, 0);
			}
		});
		String workoutsDir = this.getExternalFilesDir(null).getAbsolutePath() + "/"
				+ Constants.PROGRAMME_FILE;
		programme.setWorkouts(new ArrayList<WorkoutBean>());
		String workoutsJson;
		try {
			workoutsJson = readFile(workoutsDir);
			Gson gson = new Gson();
			programme = gson.fromJson(workoutsJson, ProgrammeBean.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ListView listOfWorkouts = (ListView) findViewById(R.id.set_programme_list);
		adapter = new SetProgrammeAdapter(programme.getWorkouts(), this);
		listOfWorkouts.setAdapter(adapter);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0) {

			if (resultCode == RESULT_OK) {
				String name = data.getStringExtra(Constants.NAME);
				WorkoutBean workout = new WorkoutBean(name);
				programme.getWorkouts().add(workout);
				updateJsonInfo();
				adapter.notifyDataSetChanged();
			}
		}
	}

	private String readFile(String path) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0,
					fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}

	public void updateJsonInfo() {
		Gson gson = new Gson();
		String programmeJson = gson.toJson(programme);
		String dir = this.getExternalFilesDir(null).getAbsolutePath() + "/"
				+ Constants.PROGRAMME_FILE;
		File workoutFile = new File(dir);
		PrintStream stream = null;
		try {
			workoutFile.createNewFile();
			stream = new PrintStream(workoutFile);
			stream.print(programmeJson);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}
}
