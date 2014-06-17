package com.example.bmi;


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

public class MainActivity extends Activity {
	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_Quit = Menu.FIRST + 1;
	/**
	 * Create activity
	 */
	private Button button_calc;
	private EditText field_height;
	private EditText field_weight;
	private TextView view_result;
	private TextView view_suggest;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Listen for button clicks
		findViews();
		setListener();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		menu.add(0, MENU_ABOUT,0,"关于。。。");
		menu.add(0, MENU_Quit, 0 ,"结束");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		super.onOptionsItemSelected(item);
		switch(item.getItemId()){
		case MENU_ABOUT:
			openOptionsDialog();
			break;
		case MENU_Quit:
			finish();
			break;
		}
		return true;
	}
	
	private void setListener() {
		// TODO Auto-generated method stub
		button_calc.setOnClickListener(calcBMI);
	}

	private void findViews() {
		// TODO Auto-generated method stub
		button_calc = (Button) findViewById(R.id.submit);
		field_height = (EditText)findViewById(R.id.height);
		field_weight = (EditText)findViewById(R.id.weight);
		view_result = (TextView)findViewById(R.id.result);
		view_suggest = (TextView) findViewById(R.id.suggest);
	}
	
	private OnClickListener calcBMI = new Button.OnClickListener() {
		public void onClick(View v){
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Report.class);
			
			Bundle bundle = new Bundle();
			bundle.putString("KEY_HEIGHT", field_height.getText().toString());
			bundle.putString("KEY_WEIGHT", field_weight.getText().toString());
			
			intent.putExtras(bundle);
			startActivity(intent);
			
//			try{
//				DecimalFormat nf = new DecimalFormat("0.00");
//				double height = Double.parseDouble(field_height.getText().toString())/100;
//				double weight = Double.parseDouble(field_weight.getText().toString());
//				double BMI = weight/(height*height);
//				view_result.setText("Your BMI is "+ nf.format(BMI));
//				//Give health advice
//				if(BMI > 25){
//					view_suggest.setText(R.string.advice_heavy);
//				}else if(BMI < 20){
//					view_suggest.setText(R.string.advice_light);
//				}else{
//					view_suggest.setText(R.string.advice_average);
//				}
//			}catch(Exception e){
//				Toast.makeText(MainActivity.this, R.string.input_error, Toast.LENGTH_SHORT)
//				.show();
//			}
		}
	};
	
	private void openOptionsDialog(){Toast.makeText(this, "BMI 计算器\nFrom Mike", Toast.LENGTH_SHORT)
		.show();
		
		new AlertDialog.Builder(this)
		.setTitle(R.string.about_title)
		.setMessage(R.string.about_msg)
		.setPositiveButton(R.string.ok_label,new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		})
		.setNegativeButton(R.string.homepage_label,new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse(getString(R.string.homepage_uri));
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);
			}
		})
		.show();
	}

	
}
