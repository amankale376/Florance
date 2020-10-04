package fs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fs.entity.About;

public class DAO_admin_about {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(About.class).buildSessionFactory();
	
	public void saveInfo(About info) {
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		session.update(info);
		session.getTransaction().commit();
		System.out.println("info updated");
	}
	public About getInfo() {
Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		About info = session.get(About.class, 1);
		session.getTransaction().commit();
		System.out.println("info retrived");
		return info;
	}
		
}
