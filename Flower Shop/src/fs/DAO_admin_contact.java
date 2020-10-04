package fs;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fs.entity.Contact;

public class DAO_admin_contact {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Contact.class).buildSessionFactory();
	
	public Contact addInfo(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Contact info=session.get(Contact.class, 1);
		return info;
		}
	
	public void storeInfo(Contact contact) {
		Session session = factory.getCurrentSession();
	session.beginTransaction();
	session.update(contact);
	System.out.println(contact.getCall());
	System.out.println(contact.getId());
	System.out.println(contact.getEmail());
	System.out.println(contact.getLocation());
	System.out.println(contact.getParagraph());
		session.getTransaction().commit();
		System.out.println("Info updated");
	
	}
}
