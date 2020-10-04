package fs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fs.entity.New_enq;

public class DAO_admin_new_enq {
SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(New_enq.class).buildSessionFactory();

		public List<New_enq> new_enq_info() {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			List<New_enq> list = session.createQuery("from new_enq").list();
			session.close();
		
			return list;
			
		}
		public void deleteList() {
			List<New_enq> list = new_enq_info();
			int a = list.size();
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("DELETE from new_enq").executeUpdate();
			session.getTransaction().commit();
			session.close();
			System.out.println("information deleted");
		}
		
		public void saveEnq(New_enq info) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(info);
			session.getTransaction().commit();
			System.out.println("information saved");
		}
		
		
}
