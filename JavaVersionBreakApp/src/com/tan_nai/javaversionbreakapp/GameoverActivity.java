package com.tan_nai.javaversionbreakapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameoverActivity extends Activity implements OnClickListener{
	
	private Button return_to_start_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameover);
		
		return_to_start_button=(Button) findViewById(R.id.return_to_start_button);
		return_to_start_button.setOnClickListener(this);
		
	}
		
		
	@Override
	public void onClick(View v) {
		if(v == return_to_start_button){
			Intent intent = new Intent(this, StartActivity.class);
			startActivity(intent);
		}
	}

		
}