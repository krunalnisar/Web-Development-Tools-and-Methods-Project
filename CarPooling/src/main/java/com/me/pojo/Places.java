package com.me.pojo;

import java.util.Set;

public class Places {

	private int placeId;
	private String places;
	private String latitude;
	private String longitude;
	
	//one-to-one
	private Set<Trip> sourceId;
	
	//one-to-one
	private Set<Trip> destinationId;

	public Places()
	{
		
	}
	
		public int getPlaceId() {
			return placeId;
		}

		public void setPlaceId(int placeId) {
			this.placeId = placeId;
		}

		public String getPlaces() {
			return places;
		}

		public void setPlaces(String places) {
			this.places = places;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public Set<Trip> getSourceId() {
			return sourceId;
		}

		public void setSourceId(Set<Trip> sourceId) {
			this.sourceId = sourceId;
		}

		public Set<Trip> getDestinationId() {
			return destinationId;
		}

		public void setDestinationId(Set<Trip> destinationId) {
			this.destinationId = destinationId;
		}
		
	
		
		
		
}
