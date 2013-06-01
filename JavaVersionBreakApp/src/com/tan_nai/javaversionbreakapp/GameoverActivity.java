package com.tan_nai.javaversionbreakapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GameoverActivity extends Activity implements OnClickListener{
	
	private Button return_to_start_button;
	private TextView result_version;
	private TextView result_label;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameover);
		result_version = (TextView)findViewById(R.id.version_text);
		result_label = (TextView)findViewById(R.id.result_label);
		
		return_to_start_button=(Button) findViewById(R.id.return_to_start_button);
		return_to_start_button.setOnClickListener(this);
		
		Intent intent = getIntent();
		if(intent.getExtras().getInt("result")>=1000){
			result_label.setText("CLEAR!!!!!!!!!");
			result_version.setText("Congratulations!!!");
		}else{
			result_version.setText("JDK7u"+intent.getExtras().getInt("result"));
		}
	}
		
		
	@Override
	public void onClick(View v) {
		if(v == return_to_start_button){
			Intent intent = new Intent(this, StartActivity.class);
			startActivity(intent);
			finish();
		}
	}

		
}