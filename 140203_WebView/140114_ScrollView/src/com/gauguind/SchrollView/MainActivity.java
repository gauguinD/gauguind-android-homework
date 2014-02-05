package com.gauguind.SchrollView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView imageView01;
	ImageView imageView02;
	int imageIndex = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		imageView01 = (ImageView) findViewById(R.id.imageView01);
		imageView02 = (ImageView) findViewById(R.id.imageView02);
		imageView02.setVisibility(View.INVISIBLE);
		
		Button button01 = (Button) findViewById(R.id.button01);
		button01.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				changeImage(0);
			}
		});
		
		Button button02 = (Button) findViewById(R.id.button02);
		button02.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				changeImage(1);
			}
		});
		
		
		
	

	}
	
	private void changeImage(int imageIndex){
		if (imageIndex == 0){
			imageView01.setVisibility(View.VISIBLE);
			imageView02.setVisibility(View.INVISIBLE);
			imageIndex = 1;
			} else if (imageIndex == 1){
			imageView01.setVisibility(View.INVISIBLE);
			imageView02.setVisibility(View.VISIBLE);
			imageIndex = 0;
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
