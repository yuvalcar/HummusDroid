package com.yuvalc.hummusdroid;

import android.location.Location;

public interface INavigation {
	public String createNavigationQuery(Location destination);
}
