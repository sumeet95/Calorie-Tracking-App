package com.example.finalassignment;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Calorie_Logs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calorie__logs);
		
		TextView txt_log = (TextView) findViewById(R.id.textView1);
		
		DatabaseHandler db = new DatabaseHandler(this);
		
		List<Cal_Log> logs = db.getAllCAL_LOGS();
		
        for (Cal_Log l : logs) {
            String log = "Id: "+ l.get_id() +"\nDate: " + l.get_date() + "\nCalories Eaten: " + l.get_calorie_intake();
            txt_log.setText(txt_log.getText().toString() + "\n\n" + log);
        }

	}

}
