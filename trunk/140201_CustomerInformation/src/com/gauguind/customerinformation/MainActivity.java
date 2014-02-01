package com.gauguind.customerinformation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	final static int DIALOG_1 = 0;
	EditText year;
	EditText month;
	EditText day;
	LayoutInflater inflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText name = (EditText)findViewById(R.id.editText1);
		EditText pass = (EditText)findViewById(R.id.editText2);
		
		Button button1 = (Button)findViewById(R.id.button01);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DIALOG_1);
				
				//Intent newIntent = new Intent(getBaseContext(), AlertDialogActivity.class);
				//startActivityForResult(newIntent, DIALOG_1);
			}
		});

		
		

		
	}
	
	private AlertDialog oncreateDialogBox(int id){
		
		
		switch (id) {
			case DIALOG_1:
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
		}
	
		return null;
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
