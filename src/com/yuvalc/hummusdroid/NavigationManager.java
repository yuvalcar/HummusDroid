package com.yuvalc.hummusdroid;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;

public class NavigationManager {
	
	public enum NAVIGATION_TYPE {WAZE, GOOGLE};
	
	NavigationManager(Context _context)
	{
		this.context = _context;
		this.navigationType = null;
		this.lastKnownDestination = null;
	}
	
	void setNevigationType(NAVIGATION_TYPE nType)
	{
		switch (nType)
		{
			case WAZE: 
				navigationType = new WazeNavigation();
				break;
			case GOOGLE:
				navigationType = new GoogleNavigation();
				break;
		}
	}
	
	void setDestination(Location destination)
	{
		lastKnownDestination = destination;
	}
	
	void navigateToLastKnownDestination()
	{
		String navigationQuery = navigationType.createNavigationQuery(lastKnownDestination);
		
		launchNavigationIntent(navigationQuery);
	}
	
	void navigateTo(Location destination)
	{
		String navigationQuery = navigationType.createNavigationQuery(destination);
		
		launchNavigationIntent(navigationQuery);
	}
	
	void launchNavigationIntent(String navigationQuery)
	{
		Intent navigation = new Intent(Intent.ACTION_VIEW, Uri.parse(navigationQuery));
		navigation.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		context.startActivity(navigation);
	}
	
	private INavigation navigationType;
	private Context context;	
	private Location lastKnownDestination;
}
