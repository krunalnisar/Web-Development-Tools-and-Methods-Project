package com.me.dao;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.me.pojo.Passengers;
import com.me.pojo.Places;
import com.me.pojo.Trip;
import com.me.pojo.User;

public class TripDao extends DAO{

	public Trip getTrip(int tripId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("from Trip where tripId=:tripId");
		query.setInteger("tripId", tripId);
		return (Trip) query.uniqueResult();
	}

	public List<Trip> getMyTrips(Integer userId) {
		// TODO Auto-generated method stub
		List<Trip> tripList = new ArrayList();
		Session session = getSession();
		Query query = session.createQuery("from Passengers where userId=:userId");
		query.setInteger("userId", userId);
		List<Passengers> passenegerTrips =  query.list();
		
		
		Query q = session.createQuery("from Trip where userId=:userId");
		q.setInteger("userId", userId);
		List<Trip> createdTrips =  q.list();
		
		for(Passengers p : passenegerTrips)
		{
			tripList.add(p.getTrip());
		}
		
		for(Trip t : createdTrips)
		{
			tripList.add(t);
		}
		return tripList;
	}

	public void postTrip(Places start, Places end, java.sql.Date sqlStartDate,
			java.sql.Date sqlEndDate, Time sqlTripTime, float cost,
			float distance, int capacity, String comments, User u) {
		
		try{
			Session session= getSession();
			
			session.beginTransaction();
			
			Trip t= new Trip();
			
			t.setSourceId(start);
			t.setDestinationId(end);
			t.setStartDate(sqlStartDate);
			t.setEndDate(sqlEndDate);
			t.setTime(sqlTripTime);
			t.setAvailableSeats(capacity);
			t.setCost(cost);
			t.setComment(comments);
			t.setMiles(distance);
			t.setUser(u);
			u.getTripList().add(t);
		//	session.save(u);
			session.save(t);
			
			session.getTransaction().commit();
				}
				
				catch(Exception e)
				{
					System.out.print("Error in adding a trip"+e);
					
				}
		// TODO Auto-generated method stub
		
	}

	
}
