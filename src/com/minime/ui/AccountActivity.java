package com.minime.ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.minime.BankAccount;
import com.minime.IntegrationFunctions;

//import com.minimeets.R;
//import com.minimeets.core.Chat;
//import com.minimeets.ui.ChatListAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class AccountActivity extends Activity {//implements SensorEventListener {
	
	//webview for animation
	WebView webView = null;
	String bankAccountMoney = null;
	IntegrationFunctions integrationFunctions = null;
	
	// variables for Accelerometer sensor
	//private static final float SHAKE_THRESHOLD = 3.25f; // m/S**2
	//private static final int MIN_TIME_BETWEEN_SHAKES_MILLISECS = 1000;
	//private long mLastShakeTime;
	//private SensorManager mShakeSensorMgr;
	
	//variables for location service
	//double longi;
	//double latit;
	
	//variables for Yahoo weather
	//String weatherCode=null;
	//String weatherText=null;
	//String weatherTemp=null;
	//String windChill=null;
	//String windDirection=null;
	//String windSpeed = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		integrationFunctions = new IntegrationFunctions();
		addListenerOnTvGoals();
		addListenerOnTvTree();
		
		if(getIntent()!=null && getIntent().getExtras()!=null) {
			Bundle theBundle = getIntent().getExtras();
			bankAccountMoney = theBundle.getString("bank");
		}
		BankAccount bank = integrationFunctions.createBank();
		bankAccountMoney = Integer.toString(bank.getMoney());
		//yahooWeatherReportPrep("toronto,on");
		//locationService();
		doAnimationPrep();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}

	//@Override
	//protected void onStop() {
		// TODO Auto-generated method stub
		//super.onStop();
		
		// Stop motion sensors
		//mShakeSensorMgr.unregisterListener(this);
	//}
	
	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.main, menu);
		//return true;
	//}

	//@Override
	//public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
	//	int id = item.getItemId();
	//	if (id == R.id.action_settings) {
		//	return true;
		//}
	//	return super.onOptionsItemSelected(item);
	//}
	//utility function to retrieve html resource file into a string
	 //public String getMsg(int fileResourceID, Context context) {
	//	 return Utility.getMsg(fileResourceID, context);
	// }	
	 //utility function to output debug message
	 //public void debug(String msg) {
	//	 Utility.debug(msg);
	 //}
	 //utility function to log an error
	 //public void error(Exception e) {
	//	 Utility.error(e);
	 //}
	 //button click event handler to start animation move
	 public void addListenerOnTvGoals() {
			 
			TextView tvGoals = (TextView) findViewById(R.id.tvGoals);
	 
			tvGoals.setOnClickListener(new OnClickListener() {
	       
				@Override
				public void onClick(View arg0) {
					
					Intent intent = new Intent(AccountActivity.this, GoalsActivity.class);
					
					intent.putExtra("bank", "bankAccountMoney");
					//intent.putExtra("value1", value1);
					//intent.putExtra("value2", value2);

					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK );

					startActivity(intent);
				}
				
			});
		}
	 
	 public void addListenerOnTvTree() {
		 
			TextView tvTree = (TextView) findViewById(R.id.tvTree);
	 
			tvTree.setOnClickListener(new OnClickListener() {
	       
				@Override
				public void onClick(View arg0) {
					
					Intent intent = new Intent(AccountActivity.this, TreeActivity.class);

					intent.putExtra("bank", "bankAccountMoney");
					//intent.putExtra("value1", value1);
					//intent.putExtra("value2", value2);

					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK );

					startActivity(intent);
				}
				
			});
		}
	 
	 /*
	 public void addListenerOnEditAction() {
		 
			EditText edtDeposit = (EditText) findViewById(R.id.edtDeposit);
	 
			edtDeposit.setOnEditorActionListener(new OnEditorActionListener() {
			    @Override
			    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			        boolean handled = false;
			        if (actionId == EditorInfo.IME_ACTION_DONE) {
			        	EditText edtDeposit = (EditText) findViewById(R.id.edtDeposit);
						int depositInt = Integer.parseInt(edtDeposit.getText().toString());
						int currentMoney = Integer.parseInt(bankAccountMoney);
						webView.loadUrl("javascript:(depositInt+currentMoney)");
			        	//Chat[] chatlist = integrationFunctions.searchChats(searchchatsStr, integrationFunctions.retrieveOwner().getUserUUID());
			        	// Initialize the UI components
			    		//chatListMenuView = (ListView) findViewById(R.id.chatlist_activity);		
			    		
			    		//chatList is an array of Chats
			    		//get chatList from your integration functions
			       		//chatListAdapter = new ChatListAdapter(context_, chatlist);
			        		
			        	// By using setAdapter method, you plugged the ListView with adapter
			        	//chatListMenuView.setAdapter(chatListAdapter);
			        	
			        	
			            handled = true;
			        }
			        return handled;
			    }
			});
		}
		*/

	/**
	 * prepare for webview animation
	 */
	private void doAnimationPrep() {
		  String mime = "text/html";
		  String encoding = "utf-8";
		  webView = (WebView) findViewById(R.id.wvAnimationAccount);
		  String templateHtml = Utility.getMsg(R.raw.account, this);
		  webView.getSettings().setJavaScriptEnabled(true);
		  //webView.addJavascriptInterface(this, "Android"); 
		  webView.loadDataWithBaseURL(null, templateHtml, mime, encoding, null);
	}
	/**
	 * prepare for shake event handling
	 */
	/*
	private void doShakePrep() {
		// Get a sensor manager to listen for shakes
		mShakeSensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
		// Listen for shakes
		Sensor accelerometer = mShakeSensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		if (accelerometer != null) {
			mShakeSensorMgr.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		}
	}
	*/

	 /**
	  * shake event handling; required by SensorEventListener interface
	  */
	/*
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			onShakeEvent(event);
		}		
	}
	*/

	/**
	 * ignore; required by SensorEventListener interface
	 */
	/*
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	*/

	/**
	 * shake event handling; called by onSensorChanged
	 * @param event
	 */
	/*
	private void onShakeEvent(SensorEvent event) {
		long curTime = System.currentTimeMillis();
		if ((curTime - mLastShakeTime) > MIN_TIME_BETWEEN_SHAKES_MILLISECS) {

			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];

			double accelerationX = Math.sqrt(Math.pow(x, 2)) - SensorManager.GRAVITY_EARTH;
			double accelerationY = Math.sqrt(Math.pow(y, 2)) - SensorManager.GRAVITY_EARTH;
			double accelerationZ = Math.sqrt(Math.pow(z, 2)) - SensorManager.GRAVITY_EARTH;
			/*
			double acceleration = Math.sqrt(Math.pow(x, 2) +
					Math.pow(y, 2) +
					Math.pow(z, 2)) - SensorManager.GRAVITY_EARTH;
			debug("Acceleration is " + acceleration + "m/s^2");

			if (acceleration > SHAKE_THRESHOLD) {
				mLastShakeTime = curTime;
				debug("Shake, Rattle, and Roll");
				webView.loadUrl("javascript:myMove()");
			}
			
			if (accelerationX > SHAKE_THRESHOLD/3) {
				mLastShakeTime = curTime;
				debug("Left right shake");
				webView.loadUrl("javascript:myMoveDiagnal()");
			}
			if (accelerationY > SHAKE_THRESHOLD/3) {
				mLastShakeTime = curTime;
				debug("Up down shake");
				webView.loadUrl("javascript:myMoveDiagnal()");
			}
			if (accelerationZ > SHAKE_THRESHOLD/3) {
				mLastShakeTime = curTime;
				debug("Forward backward shake");
				webView.loadUrl("javascript:myMoveDiagnal()");
			}
		}
		
	}
	*/
	/**
	 * To translate coordinates to city names, you can use the web services of http://www.geonames.org/
       Wikipedia also provides the long./lat. of major world cities: 
       https://en.wikipedia.org/wiki/Latitude_and_longitude_of_cities,_A-H
   	 * @param longi
	 * @param latit
	 * @return
	 */
	//private String locationCoordinates2CityProvince(double longi, double latit) {
	//	String rtn = "toronto, on";
	//	return rtn;
	//}
	/**
	 * call this function in onCreate or anytime you want to set the longi and latit once when the activity is started
	 * once the longi and latit are populated, it will stop requesting location updates, to save battery
	 */
	//private void locationService() {
		// Acquire a reference to the system Location Manager
		//final LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		/*
		String locationProvider = LocationManager.NETWORK_PROVIDER;
		// Or use LocationManager.GPS_PROVIDER
		Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
		if (lastKnownLocation!=null) {
		      double latit = lastKnownLocation.getLatitude();
		      double longi = lastKnownLocation.getLongitude();
		      debug("You are located at latit "+latit+" and longi "+longi);
		}
		*/
		
		// Define a listener that responds to location updates
		//LocationListener locationListener = new LocationListener() {
		//    public void onLocationChanged(Location location) {
		      // Called when a new location is found by the network location provider.
		  //    latit = location.getLatitude();
		   //   longi = location.getLongitude();
		   //   debug("You are located at latit "+latit+" and longi "+longi);
		      // Remove the listener you previously added
		    //  locationManager.removeUpdates(this);
		      
		      //now call yahoo weather report to get the weather/wind report
		      //do whatever you need to do
		    //  String cityProvinceStr = locationCoordinates2CityProvince(longi, latit);
		  //    yahooWeatherReportPrep(cityProvinceStr);
		  //  }

		//    public void onStatusChanged(String provider, int status, Bundle extras) {}

		//    public void onProviderEnabled(String provider) {}

		//    public void onProviderDisabled(String provider) {}
	//	  };

		// Register the listener with the Location Manager to receive location updates
		//locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		
	//}

	/**
	 * This function will start AsyncTask for wind and then for weather to populate
	 * the wind-related variables and weather-related variables.
	 * Call this function once you get your cityProvinceStr from some location services
	 * @param cityProvinceStr cityProvinceStr takes the form of "toronto,on"
	 */
	//void yahooWeatherReportPrep(String cityProvinceStr) {
	//	try {
			 //populate wind related variables
	//		 AsyncTaskGetHtml asyncTaskGetHtmlWind = new AsyncTaskGetHtml();
	//		 asyncTaskGetHtmlWind.setActivity(this);
	//		 String query=URLEncoder.encode("select wind from weather.forecast where woeid in (select woeid from geo.places(1) where text='"+cityProvinceStr+"')","UTF-8");
	//		 asyncTaskGetHtmlWind.execute("https://query.yahooapis.com/v1/public/yql?q="+query);
			
			 //populate weather related variables
	//		 AsyncTaskGetHtml asyncTaskGetHtmlWeather = new AsyncTaskGetHtml();
	//		 asyncTaskGetHtmlWeather.setActivity(this);
	//		 query=URLEncoder.encode("select item.condition from weather.forecast where woeid in (select woeid from geo.places(1) where text='"+cityProvinceStr+"')","UTF-8");
	//		 asyncTaskGetHtmlWeather.execute("https://query.yahooapis.com/v1/public/yql?q="+query);
			
	//	}catch (UnsupportedEncodingException e) {
			
	//	}
	//}
	/**
	 * This function is called from AsyncTaskGetHtml when yahoo weather report html response comes back
	 * @param result
	 */
	//void yahooWeatherReportProcess(String result) {
	//	if (result==null)
			//return;
		
		//chill="59" direction="75" speed="29"
	//	if (result!=null && !result.isEmpty()) {
		//	String windChill = Utility.substring(result, "chill=\"", "\"");
	//		String windDirection = Utility.substring(result, "direction=\"", "\"");
	//		String windSpeed = Utility.substring(result, "speed=\"", "\"");
	//		if (windChill!=null)
	//			this.windChill = Utility.substring(result, "chill=\"", "\"");
	//		if (windDirection!=null)
	//			this.windDirection = Utility.substring(result, "direction=\"", "\"");
	//		if (windSpeed!=null)
	//			this.windSpeed = Utility.substring(result, "speed=\"", "\"");
	//	}
	//	if (result!=null && !result.isEmpty()) {
	//		String weatherCode = Utility.substring(result, "code=\"", "\"");
	//		String weatherText = Utility.substring(result, "text=\"", "\"");
	//		String weatherTemp = Utility.substring(result, "temp=\"", "\"");
	//		if (weatherCode!=null)
	//			this.weatherCode = Utility.substring(result, "code=\"", "\"");
	//		if (weatherText!=null)
	//			this.weatherText = Utility.substring(result, "text=\"", "\"");
	//		if (weatherTemp!=null)
	//			this.weatherTemp = Utility.substring(result, "temp=\"", "\"");
	//	}
		
		//now, if you want to display something to the UI, you can do so:
	//	System.out.println("wind chill="+this.windChill);
	//	System.out.println("wind speed="+this.windSpeed);
	//	System.out.println("wind direction="+this.windDirection);
	//	System.out.println("weather code="+this.weatherCode);
	//	System.out.println("weather text="+this.weatherText);
	//	System.out.println("weather temp="+this.weatherTemp);
	//}
}
