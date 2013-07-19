package com.atanas.tsankov.nfitness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class SplashScreenActivity extends Activity {
	private boolean isStopped = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		new Thread(new Runnable() {

			@Override
			public void run() {
				int counter = 0;
				while (!isStopped) {
					try {
						Thread.sleep(500);
						counter++;
						if (counter == 5) {
							isStopped = true;
						}
					} catch (InterruptedException e) {
						isStopped = true;
					}
				}
				if (SplashScreenActivity.this.hasWindowFocus()) {
					startActivity(new Intent(SplashScreenActivity.this,
							MainMenuActivity.class));
				} else {
					SplashScreenActivity.this.finish();
				}
			}
		}).start();
		LinearLayout splashLayout = (LinearLayout) findViewById(R.id.splash_layout_id);
		splashLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				isStopped = true;
			}
		});
	}

}
