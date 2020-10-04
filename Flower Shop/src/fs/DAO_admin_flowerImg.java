package fs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fs.entity.Flowers_img;

public class DAO_admin_flowerImg {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Flowers_img.class).buildSessionFactory();
 
		public void addImages(String name) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
		Flowers_img img = new Flowers_img(name);
		session.save(img);
		session.getTransaction().commit();
		}
		
		public List<Flowers_img> getImages() {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			List<Flowers_img> img = session.createQuery("from flowers_img").getResultList();
			session.getTransaction().commit();
			return img;
		}
		
		public void deleteImg(int id) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Flowers_img img = session.get(Flowers_img.class, id);
			session.delete(img);
			session.getTransaction().commit();
		}
}
