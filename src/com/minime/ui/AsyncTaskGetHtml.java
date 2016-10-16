package com.minime.ui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.app.Activity;
import android.os.AsyncTask;

/**
 * This is an example of using AsyncTask
 * Refer to the diagram in http://stackoverflow.com/questions/9671546/asynctask-android-example
 * 
 * To use this class, in your activity:
 * AsyncTaskGetHtml asyncTaskGetHtml = new AsyncTaskGetHtml();
 * asyncTaskGetHtml.setActivity(this);
 * asyncTaskGetHtml.execute("https://query.yahooapis.com/v1/public/yql?q=select wind from weather.forecast where woeid in (select woeid from geo.places(1) where text='orlando,fl')&format=json&callback=callbackFunctionWind");
 * 
 * You also need to put your custom code into:
 * onPreExecute() 
 * onPostExecute(String result) 
 * onProgressUpdate(Integer... values) 
 * onCancelled(String result)  
 * onCancelled()
 * @author allen
 *
 */
public class AsyncTaskGetHtml extends AsyncTask <String, Integer, String>{

	Activity myActivity = null;
	public void setActivity(Activity activity) {
		myActivity = activity;
	}
	@Override
	//the returned string will be used as input string for onPostExecute(String result)
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		//pass this parameter by calling
		//new AsyncTaskGetHtml().execute("https://query.yahooapis.com/v1/public/yql?q=select wind from weather.forecast where woeid in (select woeid from geo.places(1) where text='orlando,fl')&format=json&callback=callbackFunctionWind");
		String serverUrl = params[0];
		String htmlResponse = null;
		int progress = 0;
		try {
			
			URL url = new URL(serverUrl);
			
			//Use HttpsURLConnection or HttpURLConnection
			HttpURLConnection urlConnection = null;
			if (serverUrl.toLowerCase().startsWith("https"))
				urlConnection = (HttpsURLConnection) url.openConnection(); 
			else
				urlConnection =  (HttpURLConnection)url.openConnection();
			
			progress++;
			publishProgress(progress);//progress will be used as parameter for onProgressUpdate(Integer... values)	
			
			try {
				
			     urlConnection.setChunkedStreamingMode(0);
			     urlConnection.setRequestMethod("GET");
						
			     urlConnection.setUseCaches (false);
			     urlConnection.setDoInput(true);
			     //urlConnection.setDoOutput(true);
			     
			      //Get Response	
			      InputStream is = urlConnection.getInputStream();
			      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			      String line;
			      
				  progress++;
			      publishProgress(progress);//progress will be used as parameter for onProgressUpdate(Integer... values)	
			      
			      StringBuffer response = new StringBuffer(); 
			      while((line = rd.readLine()) != null) {
			        response.append(line);
			        response.append('\r');
			        
					progress++;
					publishProgress(progress);//progress will be used as parameter for onProgressUpdate(Integer... values)	
			      
			      }
			      
			      rd.close();
			      htmlResponse = new String(response);
			      
				  progress++;
				  publishProgress(progress);//progress will be used as parameter for onProgressUpdate(Integer... values)	
			      
			}
			catch (Exception e) {
				 e.printStackTrace(); 
			}
			finally {
				if(urlConnection != null) {
			     urlConnection.disconnect();
				} 
			}

		} catch (Exception e) {
			e.printStackTrace(); 
		}

		return htmlResponse;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		//super.onPostExecute(result);
		//You can either put the result onto some UI element like TextView or call 
		//one of the functions of the activity 
		((MainActivity)myActivity).yahooWeatherReportProcess(result);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
		System.out.println(values[0]);
	}

	@Override
	protected void onCancelled(String result) {
		// TODO Auto-generated method stub
		super.onCancelled(result);
	}

	@Override
	protected void onCancelled() {
		// TODO Auto-generated method stub
		super.onCancelled();
	}

}
