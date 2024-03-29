package com.example.myfirstapp;

//import static android.support.v4.app.FragmentActivity.TAG;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.*;

import java.util.Locale;


public class ScreenSlidePagerActivity extends ActionBarActivity {
	
	//the images to display
	 Integer[] imageIDs = {
	 R.drawable.pic1,
	 //R.drawable.pic2,
	 //R.drawable.pic3,
	 //R.drawable.pic4,
	 //R.drawable.pic5,
	 //R.drawable.pic6,
	 //R.drawable.pic7
	 };

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_slide_pager);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.screen_slide_pager, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			return PlaceholderFragment.newInstance(position + 1);
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 8;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			//case 2:
			default:
				return getString(R.string.title_section3).toUpperCase(l);
			
			}
			//return null;
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
			 
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			int nSectionNumber = this.getArguments().getInt(ARG_SECTION_NUMBER);
			String sSectionNumber = Integer.toString(nSectionNumber);
			Log.i("pager demo", "section number = " + sSectionNumber);
			
			View rootView = null;
			
			switch (nSectionNumber) {
				case 1:		rootView = inflater.inflate(R.layout.fragment_screen_slide_pager_01_touch, container, false);	break;
				case 2:		rootView = inflater.inflate(R.layout.fragment_screen_slide_pager_02_long_press, container, false);	break;
				case 3:		rootView = inflater.inflate(R.layout.fragment_screen_slide_pager_03_swipe_or_drag, container, false);	break;
				case 4:		rootView = inflater.inflate(R.layout.fragment_screen_slide_pager_04_long_press_drag, container, false);	break;
				case 5:		rootView = inflater.inflate(R.layout.fragment_screen_slide_pager_05_double_touch, container, false);	break;
				case 6:		rootView = inflater.inflate(R.layout.fragment_screen_slide_pager_06_double_touch_drag, container, false);	break;
				
				case 7: {
					FragmentBase fragment = FragmentPinchOpen.getInstance(inflater, container);					
					rootView = fragment.getRootView();
				}
				break;
				
				case 8:	{
					rootView = inflater.inflate(R.layout.fragment_screen_slide_pager_08_pinch_close, container, false);
				}
				break;
				
				default: {
					rootView = inflater.inflate(R.layout.fragment_screen_slide_pager_01_touch, container, false);	break;
				}
			}
			
			return rootView;
		}
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//Log.w("remote_control, onTouchEvent", Integer.toString((int)SystemClock.uptimeMillis()));		
		
		return super.onTouchEvent(event);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onTrackballEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTrackballEvent(event);
	}
}
