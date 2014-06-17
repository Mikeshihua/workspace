package com.shihua.controlsss;

import java.util.Calendar;

import android.os.Handler;
import android.widget.ProgressBar;

public class longWork extends Thread {

	private Handler mHandler;
	private ProgressBar mProgressBar;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Calendar begin = Calendar.getInstance();
		do{
			Calendar now =Calendar.getInstance();
			final int id =60*(now.get(Calendar.MINUTE)-begin.get(Calendar.MINUTE))+
					now.get(Calendar.SECOND)-begin.get(Calendar.SECOND);
			if (id*2>100) {
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mProgressBar.setProgress(100);
					}
				});
				
				break;
			}
			if (id*4<100) {
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mProgressBar.setProgress(id*4);
					}
				});
			}
			else {
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mProgressBar.setProgress(100);
					}
				});
			}
		}while(true);
	}
	
	void setProgressBar(ProgressBar progressBar){
		mProgressBar = progressBar;
	}
	void setHandler(Handler h){
		mHandler = h;
	}

}
