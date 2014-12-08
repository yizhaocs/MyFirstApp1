package com.example.myfirstapp;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;



/// onTouchEvent to capture
/// myWebView.dispatchTouchEvent(ev);


public abstract class FragmentBase {
	protected View rootView;
	
	/**
	 * @return the rootView
	 */
	public View getRootView() {
		return rootView;
	}

	/**
	 * @param rootView the rootView to set
	 */
	public void setRootView(View rootView) {
		this.rootView = rootView;
	}

	protected boolean isRecordingInProgress;
	protected boolean isPlayingInProgress;
	
	// Each Fragment keeps its own motion events list
	protected List<MotionEvent> motionEvents = new LinkedList<MotionEvent>();
	
	public FragmentBase() {
		rootView = null;
		isRecordingInProgress = false;
		isPlayingInProgress = false;
	}
	
	protected abstract int subGetResourceId();
	protected abstract void subInit2();
	protected abstract void playRecording();

	protected void superInit(LayoutInflater inflater, ViewGroup container) {
		setRootView(inflater.inflate(subGetResourceId(), container, false));
		
		final Button buttonStartRecording = (Button) rootView.findViewById(R.id.buttonStartRecording);
		buttonStartRecording.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg) {
				//Intent intent = new Intent(context, WebViewActivity.class);
				//startActivity(intent);
				//Log.i("xxx", "Start button in page ? clicked");
				isRecordingInProgress = true;
			}
		});
		
		final Button buttonStopRecording = (Button) rootView.findViewById(R.id.buttonStopRecording);
		buttonStopRecording.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg) {
				//Intent intent = new Intent(context, WebViewActivity.class);
				//startActivity(intent);
				//Log.i("xxx", "Stop button in page ? clicked");
				isRecordingInProgress = false;
			}
		});
		
		final Button buttonPlayRecording = (Button) rootView.findViewById(R.id.buttonPlayRecording);
		buttonPlayRecording.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg) {
				//Intent intent = new Intent(context, WebViewActivity.class);
				//startActivity(intent);
				//Log.i("xxx", "Play button in page ? clicked");
				
				//buttonStartRecording.setClickable(false);
				//buttonStopRecording.setClickable(false);
				isPlayingInProgress = true;
				
				playRecording();
				
				isPlayingInProgress = false;
				//buttonStartRecording.setClickable(true);
				//buttonStopRecording.setClickable(true);
			}
		});
		
		subInit2();
	}
}
