package com.tan_nai.javaversionbreakapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends Activity implements OnClickListener{
	
	private Button start_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		start_button=(Button) findViewById(R.id.return_to_start_button);
		start_button.setOnClickListener(this);
		
	}
		
		
	@Override
	public void onClick(View v) {
		if(v == start_button){
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
	}

		
}