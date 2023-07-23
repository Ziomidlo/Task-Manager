package entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

	public static void main(String[] args) {

		System.out.println("Project started..");

		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			
			try (Session session = factory.openSession()) {
				
				Task task = session.get(Task.class, 1L);
				if (task != null) {
					System.out.println("Database connection successful!");
				} else {
					System.out.println("Task not found in the database.");
				}
				
				factory.close();
				
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Database connection failed!");
		}
	}
}
