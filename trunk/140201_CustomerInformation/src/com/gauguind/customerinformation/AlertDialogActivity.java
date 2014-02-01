package com.gauguind.customerinformation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.EditText;
import android.widget.LinearLayout;

public class AlertDialogActivity extends Activity {

	LayoutInflater inflater;
	EditText year;
	EditText month;
	EditText day;
	
	final static int DIALOG_1 = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private AlertDialog createDialogBox(int id){
		
		final LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.alertdialogactivity_main,null);
		AlertDialog alertDialogBox = new AlertDialog.Builder(this)
		
		
		.setTitle("Title")
		
		.setPositiveButton("¿˙¿Â", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				year = (EditText)findViewById(R.id.editText01);
				month = (EditText)findViewById(R.id.editText02);
				day = (EditText)findViewById(R.id.editText03);	
				
				String date = String.format("year: %s\nmonth: %s\ndate: %s",year.getText().toString(),month.getText().toString(),day.getText().toString());	
			}
		})
		
		.setNegativeButton("¥›±‚", null)
		.create();
	
		return alertDialogBox;
	}
	


}
