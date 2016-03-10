package com.me.pojo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class User {
	private Integer userId;
	private String name;
	
	private String username;
	private String password;
	
	private String gender;
	private int age;

	private String email;
	private String mobile;
	
	private CommonsMultipartFile image;
	
	private String imageFile;
	
	
	private boolean status;
	
	private String preference;
	
	private DriverDetails driverdetails;
	
	//one-to-one
	private Car car;
	
	//one-to-one
	private CardDetails cardDetails;
	
	//one-to-one
	private Address address;

	//one-to-many
	private Set<Trip> tripList;
	
	//one-to-many
	private Set<Passengers> passengerList;
	
	//many-to-many
	//private Set<User_Trip> tripStatus;
	
	//one to many
	private Set<Message> messageList;


	


	public User()
	{
		tripList = new HashSet<Trip>();
		messageList = new HashSet<Message>();
	}
	

	public Set<Trip> getTripList() {
		return tripList;
	}


	public void setTripList(Set<Trip> tripList) {
		this.tripList = tripList;
	}


	public DriverDetails getDriverdetails() {
		return driverdetails;
	}


	public void setDriverdetails(DriverDetails driverdetails) {
		this.driverdetails = driverdetails;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Passengers> getPassengerList() {
		return passengerList;
	}


	public void setPassengerList(Set<Passengers> passengerList) {
		this.passengerList = passengerList;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	


	


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getImageFile() {
		return imageFile;
	}


	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getPreference() {
		return preference;
	}


	public void setPreference(String preference) {
		this.preference = preference;
	}


	public Set<Message> getMessageList() {
		return messageList;
	}


	public void setMessageList(Set<Message> messageList) {
		this.messageList = messageList;
	}


	public CardDetails getCardDetails() {
		return cardDetails;
	}


	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}


	public CommonsMultipartFile getImage() {
		return image;
	}


	public void setImage(CommonsMultipartFile image) {
		this.image = image;
	}

	
	
	
}
