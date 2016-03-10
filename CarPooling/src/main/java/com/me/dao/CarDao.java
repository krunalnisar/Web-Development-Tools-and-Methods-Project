package com.me.dao;

import org.hibernate.Session;

import com.me.pojo.Car;
import com.me.pojo.User;

public class CarDao extends DAO{

	public void addCar(Car c,User u,String model, String type,int seats, int carno, String color) throws Exception{
        
//        
//        Session session = getSession();
//        session.beginTransaction();
//        
//        try{
//            
//            
//            c.setModelNo(modelNo);
//            c.setCapacity(seats)
//            c.setColor(color);
//            c.setModelNo(carno);
//            
//            c.setUser(u);
//            
//            u.setCar(c);
//            
//            session.save(c);
//            session.save(u);
//            session.getTransaction().commit();
//            
//        } catch(HibernateException e){
//            throw new Exception("Cannot add car " +e);
//        }
    }
}
