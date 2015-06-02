package com.example.finalassignment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainPage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		
		Button btnSetUp =  (Button)findViewById(R.id.button3);
		Button btnCalc =  (Button)findViewById(R.id.button1);
		Button btnLog =  (Button)findViewById(R.id.button2);
		btnSetUp.setOnClickListener(new Clicker());
		btnCalc.setOnClickListener(new Clicker());
		btnLog.setOnClickListener(new Clicker());
	}
	
	private class Clicker implements OnClickListener {
		public void onClick(View v) {
			try {
				
				switch(v.getId()){
				case R.id.button3:
				Intent myIntent = new Intent(MainPage.this,
						MainActivity.class);
				startActivity(myIntent);
				break;
				
				case R.id.button1:
				Intent calcIntent = new Intent(MainPage.this,
						Calculator.class);
				startActivity(calcIntent);
				break;
				
				case R.id.button2:
				Intent logIntent = new Intent(MainPage.this,
						Calorie_Logs.class);
				startActivity(logIntent);
				break;
				}
				
			} catch (Exception e) {
				Toast.makeText(getBaseContext(), e.getMessage(),
						Toast.LENGTH_LONG).show();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.help) {
			Intent i = new Intent(this, HelpActivity.class);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
