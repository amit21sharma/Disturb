package com.example.disturb;



import android.app.ActionBar;
import android.os.Bundle;
import android.annotation.SuppressLint;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button next1;
	TextView phonenum,countrycode;
	int duration = Toast.LENGTH_SHORT;
	String CountryID="";
	String CountryZipCode="";
	String plus="+";
	//ActionBar actionBar;
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Context context = this;
		next1 = (Button) findViewById(R.id.next1);
		phonenum= (TextView) findViewById(R.id.phonenum);
		countrycode=(TextView) findViewById(R.id.countrycode);
		TelephonyManager manager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
		//getNetworkCountryIso
		CountryID= manager.getSimCountryIso().toUpperCase();
		String[] rl=this.getResources().getStringArray(R.array.CountryCodes);
		for(int i=0;i<rl.length;i++){
			String[] g=rl[i].split(",");
			if(g[1].trim().equals(CountryID.trim())){
				CountryZipCode=g[0];break;  }

		}
		plus= "+" + CountryZipCode;
		countrycode.setText(plus); 
		phonenum.requestFocus();


		//actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#a99aa0")));


		next1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent1 = new Intent(context,Sms_Verification.class);

				if (phonenum.getText().length()==0 || countrycode.getText().length()==0)
				{  if(countrycode.getText().length()==0)
				{
					Toast toast1 = Toast.makeText(context,"Country code field required" ,duration );
					toast1.show();
				}
				else{
					Toast toast2 = Toast.makeText(context,"Phone number field required", duration);
					toast2.show();
				}
				}
				else
				{
					startActivity(intent1);
				}
			}
		});


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//ActionBar.setBackgroundDrawable(R.drawable);
		setTitle("Welcome");
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

}