package fs;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fs.entity.Login;

public class DAO_admin_login {
		
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Login.class).buildSessionFactory();
	
	public Login getDetails() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Login detail =  session.get(Login.class, 1);
		session.close();
		factory.close();
		return detail;
	}

	public void updateInfo(String username, String confirmPassword) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Login info = new Login(1,username, confirmPassword);
		session.update(info);
		session.getTransaction().commit();
	}
	
}
