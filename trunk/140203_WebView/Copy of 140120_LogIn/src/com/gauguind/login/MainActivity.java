package com.gauguind.login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	protected static final int REQUEST_CODE_NEW = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button button0 = (Button) findViewById(R.id.button00);
        button0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//Toast.makeText(getApplicationContext(), "Toast 메세지 입니다.", Toast.LENGTH_LONG).show();
				
				Intent myIntent = new Intent(getApplicationContext(), New_Activity.class);
				startActivityForResult(myIntent, REQUEST_CODE_NEW);
				
			}
		});
        
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	String name = data.getExtras().getString("button");
    	Toast toast = Toast.makeText(getBaseContext(), name, Toast.LENGTH_LONG);
    	toast.show();
    		
    	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
