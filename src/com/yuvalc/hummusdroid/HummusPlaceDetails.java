package com.yuvalc.hummusdroid;

import java.io.Serializable;

import com.google.api.client.util.Key;

public class HummusPlaceDetails implements Serializable {

	/**
	 * Just the default one for now
	 */
	private static final long serialVersionUID = 1L;

	@Key
	public String status;
	
	@Key
	public HummusPlace result;

	@Override
	public String toString() {
		if (result!=null) {
			return result.toString();
		}
		return super.toString();
	}
}
