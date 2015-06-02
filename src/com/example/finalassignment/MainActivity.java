package com.example.finalassignment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity {
	boolean submit = false;
	private double calorie_intake;
	Button btnCallActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        btnCallActivity = (Button) findViewById(R.id.button1);
        btnCallActivity.setOnClickListener(new Clicker());
    }
    
    private class Clicker implements OnClickListener {
    	@Override
    	public void onClick(View v) {
    		EditText weight = (EditText) findViewById(R.id.editText1);
    		EditText height = (EditText) findViewById(R.id.editText2);
    		
    		if(height.getText().toString().equals("")){
    			TextView txt_height = (TextView) findViewById(R.id.textView3);
    			txt_height.setText("* Required");
    			submit = false;
    		} else {
    			TextView txt_height = (TextView) findViewById(R.id.textView3);
    			txt_height.setText("");
    			submit = true;
    		}
    		
    		if (weight.getText().toString().equals("")) {
    			TextView txt_ne = (TextView) findViewById(R.id.textView4);
    			txt_ne.setText("* Required");
    			submit = false;
    		} else {
    			TextView txt_weight = (TextView) findViewById(R.id.textView3);
    			txt_weight.setText("");
    			submit = true;
    		}
    		
    		if(submit == true){
    			TextView txt_calories = (TextView) findViewById(R.id.textView5);
    			calorie_intake = (66 + 
						(6.3 * Integer.parseInt(weight.getText().toString())) + 
					    10 * Integer.parseInt(height.getText().toString()));
    			
    			txt_calories.setText("Your Calorie intake \n " +
    				 "should be :" + String.valueOf(calorie_intake));
    		}
    		
    	}
    }
    
}
