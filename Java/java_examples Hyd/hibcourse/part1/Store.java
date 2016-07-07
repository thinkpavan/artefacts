import javax.security.auth.login.Configuration;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.*;


public class Store {
public static void main(String[] args) throws java.text.ParseException {
SessionFactory sessionFactory;
try {

	sessionFactory = new net.sf.hibernate.cfg.Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	// create a new student object and store it in db.
	Stud s1 = new Stud();
	s1.setName("Student One");
	s1.setFatherName("Father One");
	s1.setAddress("ameerpet");
	Stud s2 = new Stud();
	s2.setName("Student Two");
	s2.setFatherName("Father Two");
	s2.setAddress("sr nagar");
	session.save(s1);
	session.save(s2);
	tx.commit();	
} catch (HibernateException e) {
		e.printStackTrace();
}
}
}