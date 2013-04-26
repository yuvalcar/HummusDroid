package com.yuvalc.hummusdroid;

import org.apache.http.client.HttpResponseException;

import android.util.Log;

import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;

@SuppressWarnings("deprecation")
public class GooglePlaces {

	/** Global instance of the HTTP transport. */
	private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	// Google API Key
	private static final String API_KEY = "AIzaSyD4Jw00JMw0cYRFYyv4s2G-sZo2CuJ9qhg";

	// Google Places serach url's
	private static final String PLACES_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";

	private double _latitude;
	private double _longitude;
	
	/**
	 * Searching places
	 * @param latitude - latitude of place
	 * @params longitude - longitude of place
	 * @param radius - radius of searchable area
	 * @param types - type of place to search
	 * @return list of places
	 * */
	public HummusPlacesList search(double latitude, double longitude, String types, String keyword, String language)
			throws Exception {

		this._latitude = latitude;
		this._longitude = longitude;

		try {

			HttpRequestFactory httpRequestFactory = createRequestFactory(HTTP_TRANSPORT);
			HttpRequest request = httpRequestFactory
					.buildGetRequest(new GenericUrl(PLACES_SEARCH_URL));
			
			request.getUrl().put("key", API_KEY);
			request.getUrl().put("location", _latitude + "," + _longitude);
			request.getUrl().put("rankby", "distance"); // in meters
			request.getUrl().put("sensor", "false");
			if(types != null)
				request.getUrl().put("types", types);
			
			Log.d("keyword = " , keyword);
			if(keyword!= null)
				request.getUrl().put("keyword", keyword);
			
			if(language!= null)
				request.getUrl().put("language", language);
			
			Log.d("request: ", request.getUrl().toString());

			HummusPlacesList list = request.execute().parseAs(HummusPlacesList.class);
			// Check log cat for places response status
			Log.d("Places Status", "" + list.status);
			return list;

		} catch (HttpResponseException e) {
			Log.e("Error:", e.getMessage());
			return null;
		}

	}

	/**
	 * Creating http request Factory
	 * */
	public static HttpRequestFactory createRequestFactory(
			final HttpTransport transport) {
		return transport.createRequestFactory(new HttpRequestInitializer()
		{
			public void initialize(HttpRequest request) {
				GoogleHeaders headers = new GoogleHeaders();
				headers.setApplicationName("HummusDroid");
				request.setHeaders(headers);
				JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());
				request.addParser(parser);
			}
		});
	}

}
