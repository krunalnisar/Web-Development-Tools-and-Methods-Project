package com.me.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.me.dao.DAO;
import com.me.pojo.Address;
import com.me.pojo.Car;
import com.me.pojo.CardDetails;
import com.me.pojo.DriverDetails;
import com.me.pojo.Message;
import com.me.pojo.User;

public class UserDao extends DAO{

	public User isValid(String name,String password)
	{
		System.out.println("inside login");
		Query q = getSession().createQuery("from User where username=:name and password=:password");
		System.out.println(q);
		q.setString("name", name);
		q.setString("password", password);
		User u = (User) q.uniqueResult();
		System.out.println(u);
		return u;
	}
	
	

	public boolean changePassword(String username, String orgpassword,
			String chgpassword) {
		Session session = getSession();
		session.getTransaction().begin();
		Query q = session.createQuery("from User where name=:username and password=:password");
		q.setString("username", username);
		q.setString("password", orgpassword);
		
		User u = (User) q.uniqueResult();
		
		u.setPassword(chgpassword);
		session.update(u);
		session.getTransaction().commit();
		return true;
	}

//	public boolean deleteContacts(String[] contacts) {
//		// TODO Auto-generated method stub
//		int length = contacts.length;
//		Session  session = getSession();
//		session.getTransaction().begin();
//		
//		
////			for(int i=0;i<length;i++)
////		{
////			Contacts contact = (Contacts) session.get(Contacts.class, Integer.valueOf(contacts[i]));
////			session.delete(contact);
////			//return true;
////		}
////		session.getTransaction().commit();
////		return true;
//	
//	}
	
	public List<User> listOfAllUsers(String name)
	{
		Query q = getSession().createQuery("from User where name like '"+name+"%'");
		//System.out.println(q);
		q.setString("name", name);
		//q.setString("password", password);
		List<User> abc = q.list();
		for(User u : abc)
		{
			System.out.println("hamarkhor"+u.getName());
		}
		System.out.println("list printed");
		return abc;
	}

	public User getUser(int userId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		User user = (User) session.get(User.class,userId);
		
		return user;
	}

	public boolean saveImage(User user) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.beginTransaction();
		CommonsMultipartFile commonsFile = user.getImage();
        File destFile = new File("C:\\Users\\Krunal Nisar\\Documents\\workspace-sts-3.6.4.RELEASE\\FinalProject\\src\\main\\webapp\\resources\\images", commonsFile.getOriginalFilename());
        user.getImage().transferTo(destFile);
        session.save(user);
        session.getTransaction().commit();
		return true;
		
	}



	public void saveUser(User user, Car car, DriverDetails driverdetails, CardDetails cardDetails, Address add) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.beginTransaction();
//		CommonsMultipartFile commonsFile = user.getImage();
//		File destFile = new File("F:\\uploads\\", commonsFile.getOriginalFilename());
//		user.setImageFile(destFile.getPath());
//		System.out.println(destFile.getPath());
//		
//		CommonsMultipartFile commonsFilecar = car.getImage();
//		File destFilecar = new File("F:\\uploads\\", commonsFilecar.getOriginalFilename());
//		car.getImage().transferTo(destFilecar);
//		car.setImageFile(destFilecar.getPath());
		
		
		
		 car.setUser(user);
		
		 driverdetails.setUser(user);
		 
		 
		 cardDetails.setUser(user);
		 
		 add.setUser(user);
		 
		 user.setAddress(add);
		 user.setCar(car);
		 
		 user.setDriverdetails(driverdetails);
		 
		 user.setCardDetails(cardDetails);
		 
		 session.save(user);
//		 session.save(car);
//		 session.save(driverdetails);
//		 session.save(cardDetails);
		 session.getTransaction().commit();
		
	}



	public User saveCar(User user) {
		// TODO Auto-generated method stub
		CommonsMultipartFile commonsFile = user.getImage();
		File destFile = new File("C:\\Users\\Krunal Nisar\\Documents\\workspace-sts-3.6.4.RELEASE\\FinalProject\\src\\main\\webapp\\resources\\images", commonsFile.getOriginalFilename());
		user.setImageFile(destFile.getPath());
		System.out.println(destFile.getPath());
		return user;
	}



	public Car addCarImage(Car car) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		CommonsMultipartFile commonsFilecar = car.getImage();
		File destFilecar = new File("C:\\Users\\Krunal Nisar\\Documents\\workspace-sts-3.6.4.RELEASE\\FinalProject\\src\\main\\webapp\\resources\\images", commonsFilecar.getOriginalFilename());
		car.getImage().transferTo(destFilecar);
		car.setImageFile(destFilecar.getPath());
		return car;
	}



	public boolean getUserName(String user) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.getTransaction().begin();
		Query q = session.createQuery("from User where username=:username");
		q.setString("username", user);
		User u = (User) q.uniqueResult();
		if(u == null)
		{
			System.out.println("inside getName");
		return true;
		}
		else
		{
			System.out.println("inside error");
			return false;
		}
		
	}



	public List<User> getListOfUser() {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.getTransaction().begin();
		Query q = session.createQuery("from User");
		List<User> userList = q.list();
		return userList;
	}

	public boolean changeUserStatus(String[] userId) {
		// TODO Auto-generated method stub
		int length = userId.length;
		Session  session = getSession();
		session.getTransaction().begin();
		
		
			for(int i=0;i<length;i++)
		{
			User user = (User) session.get(User.class, Integer.valueOf(userId[i]));
			//session.delete(message);

			if(user.isStatus())
			{
				user.setStatus(false);
			}
			else
			{
				user.setStatus(true);
			}
			//return true;
			session.save(user);
		}
		
		session.getTransaction().commit();
		
		
		
		return true;
	}

//	public User addUser(User user) {
//		// TODO Auto-generated method stub
//		Session session = getSession();
//		session.beginTransaction();
//		session.save(user);
//		session.getTransaction().commit();
//		return user;
//	}

	
}
