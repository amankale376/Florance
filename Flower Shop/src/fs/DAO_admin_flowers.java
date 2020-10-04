package fs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fs.entity.Flowers;


public class DAO_admin_flowers {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Flowers.class).buildSessionFactory();
	
	public void updateForm(Flowers flow) {
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		session.update(flow);
		session.getTransaction().commit();
	}
	
	public Flowers getInfo() {
	Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		Flowers getflow = session.get(Flowers.class, 1);
		session.getTransaction().commit();
		return getflow;
	}
}
