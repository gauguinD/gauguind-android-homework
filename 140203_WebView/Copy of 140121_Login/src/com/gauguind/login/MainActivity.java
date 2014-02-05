package com.gauguind.login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	protected static final int REQUEST_CODE_NEW = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText editText01 = (EditText) findViewById(R.id.editText01);
        final EditText editText02 = (EditText) findViewById(R.id.editText02);
        
        //선언 안하면 Crash 발생함
        
        Button button0 = (Button) findViewById(R.id.button00);
        button0.setOnClickListener(new OnClickListener() {
 	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String username = editText01.getText().toString();
			    String password = editText02.getText().toString();
				
			
				if(username.length() < 1){
					Toast.makeText(getApplicationContext(), "사용자명을 입력하세요", Toast.LENGTH_LONG).show();
					return;
				} else if (password.length() < 1){
					Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
					return;
				}
				else {
					Intent myIntent = new Intent(getApplicationContext(), New_Activity.class);
					startActivityForResult(myIntent, REQUEST_CODE_NEW);
				}
			
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
