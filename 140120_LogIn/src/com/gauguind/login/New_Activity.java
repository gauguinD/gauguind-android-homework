package com.gauguind.login;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class New_Activity extends Activity {

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.new_activity_main);
	        
	        
	        Button button01 = (Button) findViewById(R.id.button01);
	        button01.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					//Toast.makeText(getApplicationContext(), "�������� �����ϼ̽��ϴ�.", Toast.LENGTH_LONG).show();
					
					Intent resultIntent = new Intent();
					resultIntent.putExtra("button", "�������� �����ϼ̽��ϴ�.");
					setResult(1, resultIntent);
					finish();
				}
			});
	        
	        
	        Button button02 = (Button) findViewById(R.id.button02);
	        button02.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					//Toast.makeText(getApplicationContext(), "��������� �����ϼ̽��ϴ�.", Toast.LENGTH_LONG).show();

					Intent resultIntent = new Intent();
					resultIntent.putExtra("button", "��������� �����ϼ̽��ϴ�.");
					setResult(1, resultIntent);
					finish();
				}
			});
	        
	        Button button03 = (Button) findViewById(R.id.button03);
	        button03.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					//Toast.makeText(getApplicationContext(), "��ǰ ������ �����ϼ̽��ϴ�.", Toast.LENGTH_LONG).show();

					Intent resultIntent = new Intent();
					resultIntent.putExtra("button", "��ǰ������ �����ϼ̽��ϴ�.");
					setResult(1, resultIntent);
					finish();
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
