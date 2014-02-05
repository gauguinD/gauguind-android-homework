package com.gauguind.customerinformation;

import java.text.DateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	//final static int DIALOG_1 = 0;
	//EditText year;
	//EditText month;
	//EditText day;
	//LayoutInflater inflater;
	
	DateFormat fmDateAndTime = DateFormat.getDateInstance();
	Calendar dateAndtime = Calendar.getInstance();
	TextView dateAndtimelabel;
	String info;
	Button button1,button2;
	
	//final Button button1 = (Button)findViewById(R.id.button1);
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button)findViewById(R.id.button1);
			
		EditText name = (EditText)findViewById(R.id.editText1);
		EditText age = (EditText)findViewById(R.id.editText2);
		
		button1.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//AlertDialog diaBox = createDialogBox();
				//diaBox.show();
				//Intent newIntent = new Intent(getBaseContext(), AlertDialogActivity.class);
				//startActivityForResult(newIntent, DIALOG_1);
				
			new DatePickerDialog(MainActivity.this,d,dateAndtime.get(Calendar.YEAR),dateAndtime.get(Calendar.MONTH),dateAndtime.get(Calendar.DAY_OF_MONTH)).show();
			//button1.setText(dateAndtimelabel.getText().toString());
			//info = dateAndtimelabel.getText().toString();
			updateLabel();
			}
		});
		
		//dateAndtimelabel = (TextView)findViewById(R.id.textView4);
		
	
		
		
		button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();
			}
		});

	}
	
	
	private void updateLabel(){
		dateAndtimelabel.setText(fmDateAndTime.format(dateAndtime.getTime()));
	}
	
	
	private DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() 
	{
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			dateAndtime.set(Calendar.YEAR, year);
			dateAndtime.set(Calendar.MONTH, monthOfYear);
			dateAndtime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			updateLabel();
			
			//button1.setText((CharSequence) dateAndtimelabel);
		}
	};

	
	/*private AlertDialog createDialogBox(){
		
		//final LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.alertdialogactivity_main,null);
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
	*/
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
