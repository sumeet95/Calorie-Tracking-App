package com.example.finalassignment;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "Cal_LogManager";
	private static final String TABLE_CAL_LOGS = "CAL_LOGS";
	
	//table columns
	private static final String Cal_Log_ID = "id";
    private static final String Cal_Log_DATE = "date";
    private static final String CALORIE_INTAKE = "intake";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_LOGS_TABLE = "CREATE TABLE " + TABLE_CAL_LOGS + "("
                + Cal_Log_ID + " INTEGER PRIMARY KEY," + Cal_Log_DATE + " TEXT,"
                + CALORIE_INTAKE + " INT" 
                + ")";
        db.execSQL(CREATE_LOGS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAL_LOGS);
        
        onCreate(db);
	}
	
	public void addCal_Log(Cal_Log log) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(Cal_Log_DATE, log.get_date()); // Contact Name
	    values.put(CALORIE_INTAKE, log.get_calorie_intake()); // Contact Phone Number
	 
	    // Inserting Row
	    db.insert(TABLE_CAL_LOGS, null, values);
	    db.close(); // Closing database connection

	}
	
	public Cal_Log getCal_Log(int id){
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_CAL_LOGS, new String[] { Cal_Log_ID,
	            Cal_Log_DATE, CALORIE_INTAKE }, Cal_Log_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    Cal_Log Cal_Log = new Cal_Log(Integer.parseInt(cursor.getString(0)), //int
	            cursor.getString(1),  //string
	            Integer.parseInt(cursor.getString(2))); //int
	    
	    // return Cal_Log
	    return Cal_Log;
	}
	
	// Getting All Contacts
	 public List<Cal_Log> getAllCAL_LOGS() {
	    List<Cal_Log> Cal_LogsList = new ArrayList<Cal_Log>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_CAL_LOGS;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            Cal_Log Cal_Log = new Cal_Log();
	            Cal_Log.set_id(Integer.parseInt(cursor.getString(0)));
	            Cal_Log.set_date(cursor.getString(1));
	            Cal_Log.set_calorie_intake(Integer.parseInt(cursor.getString(2)));
	            
	            // Adding CAL_LOGS to list
	            Cal_LogsList.add(Cal_Log);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return Cal_LogsList;
	}


}
