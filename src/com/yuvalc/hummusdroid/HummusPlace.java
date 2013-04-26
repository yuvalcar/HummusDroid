package com.yuvalc.hummusdroid;

import java.io.Serializable;

import com.google.api.client.util.Key;

public class HummusPlace implements Serializable {

	/**
	 * Just the default one here
	 */
	private static final long serialVersionUID = 1L;

	@Key
	public String id;
	
	@Key
	public String name;
	
	public double rating = 0.0;
	
	@Key
	public String reference;
	
	@Key
	public String icon;
	
	@Key
	public String vicinity;
	
	@Key
	public Geometry geometry;
	
	@Key
	public String formatted_address;
	
	@Key
	public String formatted_phone_number;

	@Override
	public String toString() {
		return name + " - " + vicinity;
	}
	
	public static class Geometry implements Serializable
	{
		/**
		 * Default one for now
		 */
		private static final long serialVersionUID = 1L;
		@Key
		public Location location;
	}
	
	public static class Location implements Serializable
	{
		/**
		 * Default one for now
		 */
		private static final long serialVersionUID = 1L;

		@Key
		public double lat;
		
		@Key
		public double lng;
	}
	
}
