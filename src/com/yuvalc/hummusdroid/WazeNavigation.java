package com.yuvalc.hummusdroid;
import android.location.Location;

public class WazeNavigation implements INavigation {
	
	private final String wazeNavigationQueryHeader = "waze://?ll=";
	@Override
	public String createNavigationQuery(Location destination) {
		String fullNavigationQuery = wazeNavigationQueryHeader + destination.getLatitude()+","+destination.getLongitude() + "&navigate=yes";
		return fullNavigationQuery;
	}
}
