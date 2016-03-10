package com.me.pojo;

import java.io.Serializable;

public class User_Trip implements Serializable{

	
	private String status;
	private int statusId;
	
	private User user;
	private Trip trip;
	
	
	public User_Trip()
	{
		
	}
	

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	
	
}
