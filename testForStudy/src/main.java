import java.util.Calendar;

import android.R;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;


public class main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		Calendar nowCalendar = Calendar.getInstance();
		
		DatePickerDialog datePickerDialog =new DatePickerDialog(main.this,
				datePickeDialogListener,
				nowCalendar.get(Calendar.YEAR), 
				nowCalendar.get(Calendar.MONTH),
				nowCalendar.get(Calendar.DAY_OF_MONTH));
		datePickerDialog.show();
		
		
	}
	private DatePickerDialog.OnDateSetListener datePickeDialogListener= new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			
		}
	};
	
}
