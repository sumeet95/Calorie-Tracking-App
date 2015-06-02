package com.example.finalassignment;

public class Log {
	
	//private variables
    int _id;
    String _date;
    int _calorie_intake;
    
    public Log(){
    	//empty
    }
    
    public Log(int id, String date, int calorie_intake){
    	_id = id;
    	_date = date;
    	_calorie_intake = calorie_intake;

    }

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_date() {
		return _date;
	}

	public void set_date(String _date) {
		this._date = _date;
	}

	public int get_calorie_intake() {
		return _calorie_intake;
	}

	public void set_calorie_intake(int _calorie_intake) {
		this._calorie_intake = _calorie_intake;
	}

}
