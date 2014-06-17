package com.example.bmi;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.widget.Toast;
import android.os.Bundle;

public class Report extends Activity {
	/**
	 * Called when the activity first created.
	 */
	private Button button_back;
	private TextView view_result;
	private TextView view_suggest;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);
		findView();
		showResults();
		setListeners();
		
		
	}

	private void setListeners() {
		// TODO Auto-generated method stub
		button_back.setOnClickListener(backMain);
	}
	private Button.OnClickListener backMain = new Button.OnClickListener(){
		public void onClick(View v){
			Report.this.finish();
		}
	};

	private void showResults() {
		// TODO Auto-generated method stub
		try{
			DecimalFormat nf = new DecimalFormat("0.00");
			Bundle bundle = this.getIntent().getExtras();
			double height = Double.parseDouble(bundle.getString("KEY_HEIGHT"))/100;
			double weight = Double.parseDouble(bundle.getString("KEY_WEIGHT"));
			double BMI = weight/(height*height);
			view_result.setText(getString(R.string.bmi_result)+ nf.format(BMI));
			
			//Give health advice
			if(BMI > 25){
				view_suggest.setText(R.string.advice_heavy);
			}else if(BMI < 20){
				view_suggest.setText(R.string.advice_light);
			}else{
				view_suggest.setText(R.string.advice_average);
			}
			}catch(Exception e){
			Toast.makeText(Report.this, R.string.input_error, Toast.LENGTH_SHORT)
			.show();
		}
	}

	private void findView() {
		// TODO Auto-generated method stub
		button_back = (Button) findViewById(R.id.button_back);
		view_result = (TextView)findViewById(R.id.result);
		view_suggest = (TextView) findViewById(R.id.suggest);
	}
}
