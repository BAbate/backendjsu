package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.user;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 SessionFactory factory = new Configuration()
				                      .configure("hibernate.cfg.xml")
				                      .addAnnotatedClass(user.class)
				                      .buildSessionFactory();
		 Session session = factory.getCurrentSession();
		 
		 try {
			
 			 user _user  = new user("Neba20","neb@20","Neibyou","Tadesse");
			
			 session.beginTransaction();
			 session.save(_user);
//			 _user = session.get(user.class,2);
//			 session.delete(_user);
//			 //_user.setPassword("GodlyWomen");
			 session.getTransaction().commit();
			 System.out.println(_user.getFirstName() + " " + _user.getPassword());
			 
		 }
		 finally {
			 session.close();
			 factory.close();
		 }
		
	}

}
