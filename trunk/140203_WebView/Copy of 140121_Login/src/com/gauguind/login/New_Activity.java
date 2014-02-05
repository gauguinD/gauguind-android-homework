package com.gauguind.login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class New_Activity extends Activity {

	    protected static final int REQUEST_CODE_NEW = 0;


		@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.new_activity_main);
	        
	        Button button01 = (Button) findViewById(R.id.button01);
	        button01.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					//Toast.makeText(getApplicationContext(), "고객관리를 선택하셨습니다.", Toast.LENGTH_LONG).show();
					//Intent resultIntent = new Intent();
					
					Intent custom = new Intent(getApplicationContext(), Customer_Activity.class);
					startActivityForResult(custom, REQUEST_CODE_NEW);
					
					//startActivityForResult(newIntent, REQUEST_CODE_NEW);
					//resultIntent.putExtra("button", "고객관리를 선택하셨습니다.");
					//setResult(1, resultIntent);
				}
			});
	        
	        
	        Button button02 = (Button) findViewById(R.id.button02);
	        button02.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent sale = new Intent(getApplicationContext(), Sale_Activity.class);
					startActivityForResult(sale, REQUEST_CODE_NEW);
					
				}
			});
	        
	        Button button03 = (Button) findViewById(R.id.button03);
	        button03.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent goods = new Intent(getApplicationContext(), Goods_Activity.class);
					startActivityForResult(goods, REQUEST_CODE_NEW);
					
				}
			});
	        
	    }
		
	    protected void onActivityResult(int requestCode, int resultCode, Intent data)
	    {
	    	super.onActivityResult(requestCode, resultCode, data);
	    	
	    	String name = data.getExtras().getString("button");
    		
	    	if(resultCode == 1)
	    	{
	    		Toast toast = Toast.makeText(getBaseContext(), name, Toast.LENGTH_LONG);
	    		toast.show();
	    	}
	    	else if (resultCode == 2)
	    	{
	    		Intent resultIntent = new Intent();
			    resultIntent.putExtra("button", name);
				setResult(1, resultIntent);
				finish();
	    		
	    	}
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    
	}
