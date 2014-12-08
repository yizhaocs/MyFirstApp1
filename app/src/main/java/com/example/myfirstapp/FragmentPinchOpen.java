package com.example.myfirstapp;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FragmentPinchOpen extends FragmentBase {
	
	private static FragmentBase instance = null;
	
	public static FragmentBase getInstance(LayoutInflater inflater, ViewGroup container) {
		//if (instance == null) {
			instance = new FragmentPinchOpen();
			instance.superInit(inflater, container);			
		//}
		return instance;
	}

	private FragmentPinchOpen() {
	}

	@Override
	protected int subGetResourceId() {
		return R.layout.fragment_screen_slide_pager_07_pinch_open;
	}
	protected WebView mWebView;

	@Override
	protected void subInit2() {
		mWebView = (WebView) rootView.findViewById(R.id.webView1);
		mWebView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent me) {
				if (isRecordingInProgress) {
					// save it to a list
					//Log.i("xxx", "saving touchEvents from webView");
					/*
					Log.i("xxx", "adding MotionEvents"
							+ ": Action = " + me.getAction()
							+ ", ActionIndex = " + me.getActionIndex()
							+ ", X = " + me.getX()
							+ ", Y = " + me.getY()
					);
					*/
					// obtain(long downTime, long eventTime, int action, int pointerCount, PointerProperties[] pointerProperties, PointerCoords[] pointerCoords, int metaState, int buttonState, float xPrecision, float yPrecision, int deviceId, int edgeFlags, int source, int flags)
					// obtain(long downTime, long eventTime, int action, float x, float y, float pressure, float size, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags)
					MotionEvent newMotionEvent = MotionEvent.obtain(me.getDownTime(),me.getEventTime(),me.getAction(),me.getX(),me.getY(),me.getPressure(),me.getSize(),me.getMetaState(),me.getXPrecision(),me.getYPrecision(),me.getDeviceId(),me.getEdgeFlags());
					MotionEvent newMotionEvent2 = MotionEvent.obtain(me.getDownTime(),me.getEventTime(),me.getAction(),me.getX(),me.getY(),me.getMetaState());
					Encode e = new Encode(me.getDownTime(),me.getEventTime(),me.getAction(),me.getX(),me.getY(),me.getMetaState());
					StringBuilder json = new StringBuilder();
					json.append("{");
					json.append("\"DownTime\":"+me.getDownTime());
					json.append(",");
					json.append("\"EventTime\":"+me.getEventTime());
					json.append(",");
					json.append("\"Action\":"+me.getAction());
					json.append(",");
					json.append("\"X\":"+me.getX());
					json.append(",");
					json.append("\"Y\":"+me.getY());
					json.append(",");
					json.append("\"MetaState\":"+me.getMetaState());

					json.append("}");
					Log.d("haha",json.toString());
					try
					{
						FileOutputStream fileOut =
								new FileOutputStream("/Users/yizhao/Desktop/encode.txt");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(e);
						out.close();
						fileOut.close();
						System.out.printf("Serialized data is saved in /tmp/employee.ser");
					}catch(IOException i)
					{
						i.printStackTrace();
					}
					//MotionEvent newMotionEvent2 = MotionEvent.obtain(me);
					//Log.d("hehe",newMotionEvent.toString());

					motionEvents.add(newMotionEvent2);
				}
				return false;
			}
		});

		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setWebViewClient(new WebViewClient());
		mWebView.loadUrl("https://maps.google.com");
	}


	@Override
	protected void playRecording() {
		for (MotionEvent me : motionEvents) {
			Log.i("xxx", "reading MotionEvents");
			
			// Obtain MotionEvent object
			long downTime = SystemClock.uptimeMillis();
			long eventTime = SystemClock.uptimeMillis() + 100;
			float x = 0.0f;
			float y = 0.0f;
			// List of meta states found here:     developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
			int metaState = 0;			
			
			mWebView.onTouchEvent(me);
			//me.recycle();
			//myWebView.dispatchTouchEvent(newMotionEvent);	
		}
	}
}
