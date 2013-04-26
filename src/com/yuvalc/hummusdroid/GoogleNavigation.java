package com.yuvalc.hummusdroid;

import android.location.Location;

public class GoogleNavigation implements INavigation {

	private final String googleNavigationQueryHeader = "google.navigation:q=";
	@Override
	public String createNavigationQuery(Location destination) {
	
		String fullNavgationQuery = googleNavigationQueryHeader + destination.getLatitude()+","+destination.getLongitude();
		return fullNavgationQuery;
	}
}
