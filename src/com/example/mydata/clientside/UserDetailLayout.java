package com.example.mydata.clientside;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mydata.R;

public class UserDetailLayout extends Activity {

	static String name;

	public void setName(String value) {
		name = value;
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_details);
		TextView tv = (TextView) findViewById(R.id.TextView01);
		tv.setText(name);
	}
}