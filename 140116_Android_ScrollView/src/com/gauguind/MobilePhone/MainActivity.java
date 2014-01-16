package com.gauguind.MobilePhone;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
			
	String str;
	int i;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView text01 = (TextView)findViewById(R.id.textView01);
		final EditText edit01 = (EditText)findViewById(R.id.editText01); 
		Button button01 = (Button) findViewById(R.id.button01);
		Button button02 = (Button) findViewById(R.id.button02);
		
		edit01.addTextChangedListener(new TextWatcher(){
        	@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
        		i = edit01.length();
        		text01.setText(i+"/80");
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				Log.w("onTextChanged", s.toString());				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.w("onTextChanged", s.toString());				
			}
			
		});
		
		
        text01.setText(""+"/80");
        
      
        
		
        button01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String str = edit01.getText().toString();
				Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
			}
		});
		
		
		button02.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			    edit01.setText("");
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
