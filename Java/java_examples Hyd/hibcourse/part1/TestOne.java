//import javax.security.auth.login.Configuration;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

public class TestOne {
public static void main(String[] args) throws java.text.ParseException {
	SessionFactory sessionFactory;
	try {
			System.out.println("Initializing Hibernate");
			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("Finished Initializing Hibernate");
		} 
	catch (HibernateException e) 
		{
			e.printStackTrace();
		}
	}
}