package com.yuvalc.hummusdroid;

import java.io.Serializable;
import java.util.List;

import com.google.api.client.util.Key;

@SuppressWarnings("serial")
public class HummusPlacesList implements Serializable {

	@Key
	public String status;

	@Key
	public List<HummusPlace> results;

}