package fs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fs.entity.New_enq;
import fs.entity.Old_enq;


public class DAO_admin_old_enq {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Old_enq.class).buildSessionFactory();
	public List<Old_enq> old_enq_info() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Old_enq> list = session.createQuery("from old_enq").getResultList();
		session.close();
		
		return list;
	}
	public void addToOld(List<New_enq> list) {
	
		List<Old_enq> list2 = new ArrayList<Old_enq>();
		for(New_enq a: list) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Old_enq obj = new Old_enq(a.getName(), a.getEmail(), a.getSubject(), a.getMessage());
			session.save(obj);
			session.getTransaction().commit();
			session.close();
			
		}
		
	}
	
	public void deleteAll() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("Delete from old_enq").executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	
}
