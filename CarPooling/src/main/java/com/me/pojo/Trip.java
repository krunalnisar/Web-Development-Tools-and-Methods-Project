package com.me.pojo;

import java.util.Date;
import java.util.Set;

public class Trip {

	private int tripId;
	
	private boolean status;
	private int availableSeats;
	private float cost;
	
	//many-to-one
	private User user;
	
	//many-to-one
	private Places sourceId;
	
	//many-to-one
	private Places destinationId;
	
	//one-to-many
	private Set<Passengers> passengerList;

	//many-to-many
	//private Set<User_Trip> userStatus;
	
	//many-to-many
	private Set<Message> messageList;

	
	private float miles;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private java.sql.Time time;
	private String comment;
	
	public Trip()
	{
		
	}

	
	
	public Set<Message> getMessageList() {
		return messageList;
	}



	public void setMessageList(Set<Message> messageList) {
		this.messageList = messageList;
	}



	public float getMiles() {
		return miles;
	}



	public void setMiles(float distance) {
		this.miles = distance;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}



	public Date getTime() {
		return time;
	}



	public void setTime(java.sql.Time time) {
		this.time = time;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	



	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Places getSourceId() {
		return sourceId;
	}

	public void setSourceId(Places sourceId) {
		this.sourceId = sourceId;
	}

	public Places getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Places destinationId) {
		this.destinationId = destinationId;
	}

	public Set<Passengers> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(Set<Passengers> passengerList) {
		this.passengerList = passengerList;
	}

	
	
	
}
