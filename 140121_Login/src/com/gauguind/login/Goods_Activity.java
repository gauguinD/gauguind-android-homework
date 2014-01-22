package com.gauguind.login;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Goods_Activity extends Activity {

	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.goods_activity);
	        
	        Button button02 = (Button) findViewById(R.id.button02);
	        button02.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent resultIntent = new Intent(getApplicationContext(),MainActivity.class);
					resultIntent.putExtra("button", "상품관리 > 메뉴로 이동합니다.");
					setResult(1, resultIntent);
					finish();
				}
			});
	        
	        
	        Button button03 = (Button) findViewById(R.id.button03);
	        button03.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent resultIntent = new Intent(getApplicationContext(),New_Activity.class);
					resultIntent.putExtra("button", "상품관리 > 로그인으로 이동합니다.");
					setResult(2, resultIntent);
					finish();
					
				}
			});
	    }
}
	    
/*	    private AlertDialog createDialogBox(){
	    	AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
	    	
	    	.setTitle("Alert")
	    	.setMessage("Do you want Quit?")
	    	//.setIcon(R.drawable.alert_dialog_icon)
	    	
	    	.setPositiveButton("yes",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
			})
			
			.setNeutralButton("Quit",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
			})
			
			.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
			})
			.create();
	    	
	    	return myQuittingDialogBox;
	    }
}*/
