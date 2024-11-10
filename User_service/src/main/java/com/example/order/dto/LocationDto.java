package com.example.order.dto;

public class LocationDto {

	private String lat;
	private String lon;

	public LocationDto(String lat, String lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public LocationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
