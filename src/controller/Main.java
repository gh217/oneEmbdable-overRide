package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Vector;

import org.hibernate.Session;

import model.Address;
import model.User;

public class Main {

	public static void main(String[] args) {

		User user = new User();
		Address home = new Address();
		Address work = new Address();
		
		user.setUserName(" 3 user");
		
		
		home.setStreet("nady");
		home.setCity("saba");
		
		work.setStreet("cairo");
		work.setCity("No");
	
		user.setHome(home);
		user.setWork(work);
		
		
		
		try {
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")			
					.addAnnotatedClass(User.class)
					.buildSessionFactory();
			
			Session session = factory.openSession();
			
			session.beginTransaction();
			
			session.save(user);

			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.err.println("error");
			return;
		}finally {
			
		}
		System.out.println("done");
	}
	

}
