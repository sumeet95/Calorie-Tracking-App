package com.example.finalassignment;

import java.util.Date;

import android.R.anim;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends Activity {
	
	public static final String MYPREFS = "mySharedPreferences";
	DatabaseHandler db = new DatabaseHandler(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		
		//shared prefs
		int mode = Activity.MODE_PRIVATE;
		SharedPreferences mySharedPreferences = getSharedPreferences(MYPREFS, mode);
		int current_cals = mySharedPreferences.getInt("temp_cal", 0);
		TextView txt_cals = (TextView) findViewById(R.id.textView1);
		txt_cals.setText("Calories Eaten:" + String.valueOf(current_cals));
		
		//button handle
		Button btn_add = (Button) findViewById(R.id.button1);
		btn_add.setOnClickListener(new Clicker());
		Button btn_save = (Button) findViewById(R.id.button2);
		btn_save.setOnClickListener(new Clicker());
	}
	
	private class Clicker implements OnClickListener {
		//object
		int mode = Activity.MODE_PRIVATE;
		SharedPreferences mySharedPreferences = getSharedPreferences(MYPREFS, mode);
		SharedPreferences.Editor editor = mySharedPreferences.edit();
    	@Override
    	public void onClick(View v) {
    		
    		
    		switch(v.getId()){
    		
			case R.id.button1:
				
				
			EditText cal = (EditText)findViewById(R.id.editText1);
				if(cal.getText().toString().equals("")){
					
				} else {
			
			
			//editor
				int current_cals = mySharedPreferences.getInt("temp_cal", 0);
	    		int new_cals = Integer.parseInt(cal.getText().toString()) + current_cals;
	    		editor.putInt("temp_cal", new_cals);
	    		editor.commit();
	    		
	    		TextView txt_cals = (TextView) findViewById(R.id.textView1);
	    		txt_cals.setText("Calories Eaten:" + String.valueOf(new_cals));
	    		txt_cals.startAnimation(AnimationUtils.loadAnimation(Calculator.this , android.R.anim.slide_in_left));
	    		
				}
	    		
	    		break;
			
			
			case R.id.button2:
				int c_cals = mySharedPreferences.getInt("temp_cal", 0);
				
				//create objects for date
				Date date = new Date();
				
				//create another sharedPref for ID
				int Cal_Log_id = mySharedPreferences.getInt("Cal_Log_id", 0);
				
				//inserting
				Log.d("Insert: ", "Inserting .."); 
				//make Cal_Log object and pass to database
				Cal_Log log = new Cal_Log(Cal_Log_id, date.toString(), c_cals);
				db.addCal_Log(log);
				
				//reset sharedPref for current_cal
				editor.putInt("temp_cal", 0);
				editor.commit();
				
			
			break;
			
			}
    
    	}
    }

}
