package com.example.disturb;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Recent_Disturbs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recent__disturbs);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		setTitle("Recent Disturbs");
		getMenuInflater().inflate(R.menu.recent__disturbs, menu);
		return true;
	}

}
