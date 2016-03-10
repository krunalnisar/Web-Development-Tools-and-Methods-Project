package com.me.dao;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;






import org.hibernate.Session;






import com.me.pojo.Message;
import com.me.pojo.Passengers;
import com.me.pojo.Trip;
import com.me.pojo.User;

public class MessageDao extends DAO{

	public List<Message> listMessageByUsername(String name)
	{
		Query query = getSession().createQuery("from Message where reciever=:reciever or sender=:sender");
		query.setString("reciever", name);
		query.setString("sender", name);
		List list = query.list();
		return list;
	}
	
	public boolean insertMessage(String sender,String reciever,String messagebody)
	{
		System.out.println("insert into messages");
		Session session = getSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User where name=:name");
		query.setString("name", reciever);
		User u = (User) query.uniqueResult();
		System.out.println(u.getName());
		
		
		
		Message m = new Message();
		//m.setMessageId(1);
		m.setMessages(messagebody);
		m.setReciever(reciever);
		m.setSender(sender);
		m.setDate(new Date());
		
		
		Set<Message> messageList = new HashSet<Message>();
		messageList.add(m);
		
		u.setMessageList(messageList);
		m.setUser(u);
		
		session.save(u);
		session.save(m);
		
		
		session.getTransaction().commit();
		return true;
		
	}
	
	public List searchById(Integer id)
	{
		
		Query query = getSession().createQuery("from User where userId=:id");
		query.setInteger("id", id);
		//User u = (User) query.uniqueResult();
		return query.list();
		
	}
	
	public List searchByName(String name)
	{
		
		Query query = getSession().createQuery("from User where name=:name");
		query.setString("name", name);
		//User u = (User) query.uniqueResult();
		return query.list();
		
	}

	public boolean deleteMessage(String[] username) {
		// TODO Auto-generated method stub
		int length = username.length;
		Session  session = getSession();
		session.getTransaction().begin();
		
		
			for(int i=0;i<length;i++)
		{
			Message message = (Message) session.get(Message.class, Integer.valueOf(username[i]));
			session.delete(message);
			//return true;
		}
		session.getTransaction().commit();
		return true;
	}

	

	public boolean statusApproved(int messageId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.beginTransaction();
		Query q = session.createQuery("from Message where messageId=:messageId");
		q.setInteger("messageId", messageId);
		//Message message = (Message) session.get(Message.class, messageId);
		Message message = (Message) q.uniqueResult();
		message.setStatus("approved");
		session.update(message);
		session.getTransaction().commit();
		//session.close();
		return true;
		
	}

	public boolean statusReject(int messageId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.beginTransaction();
		Message message = (Message) session.get(Message.class, messageId);
		message.setStatus("rejected");
		session.update(message);
		session.getTransaction().commit();
		return true;
	}

	public boolean statusChanged( int tripId, int userId,int messageId) 
	{
		Session session = getSession();
		session.beginTransaction();
		
		Passengers p = new Passengers();
		
		Trip trip = (Trip) session.get(Trip.class, tripId);
		trip.setAvailableSeats(trip.getAvailableSeats()-1);
		User user = (User) session.get(User.class, userId);
		Message message = (Message) session.get(Message.class, messageId);
		message.setStatus("paymentdone");
		p.setTrip(trip);
		p.setUser(user);
		
		session.save(p);
		session.update(trip);
		session.getTransaction().commit();
		
		return true;
	}

	public void requestARide(int tripId, Trip trip, User user, String reciever, String source, String destination) {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		session.beginTransaction();
		
		Message m = new Message();
		m.setDate(new Date());
		m.setMessages(source+" to "+destination);
		m.setStatus("pending");
		m.setTrip(trip);
		m.setReciever(reciever);
		m.setSender(user.getName());
		m.setUser(user);
		//user.getMessageList().add(m);
		session.save(m);
		session.getTransaction().commit();
		
	}

	public Message getMessage(int messageId) {
		// TODO Auto-generated method stub
		Session  session = getSession();
		session.getTransaction().begin();
		Message message = (Message) session.get(Message.class, messageId);
		return message;
	}
	
	

	
	
}
