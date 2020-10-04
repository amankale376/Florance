package fs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import fs.entity.About_img;

public class DAO_admin_aboutImg {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(About_img.class).buildSessionFactory();
	
	public void addFileDb(String name){
			
		 Session session = factory.getCurrentSession();
				int id = 1;
				// create object of entity class type
				About_img img = new About_img(id,name);
				//start transaction
				session.beginTransaction();
				// perform operation
				session.update(img);
				// commit the transaction
				session.getTransaction().commit();
				System.out.println("Row added");
		
	}
	
	public About_img getImg() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		About_img img = session.get(About_img.class, 1);
		session.getTransaction().commit();
		return img;
	}
	
	public void deleteImg(int id) {
		Session	session = factory.getCurrentSession();
		session.beginTransaction();
    About_img img = new About_img(1, "");
			session.update(img);
//		session.createQuery("delete img_name from about_img where id='1'").executeUpdate();
			session.getTransaction().commit();
		}
	
}
