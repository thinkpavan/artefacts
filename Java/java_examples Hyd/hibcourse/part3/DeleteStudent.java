import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.cfg.Configuration;
import java.util.*;
public class DeleteStudent {
public static void main(String[] args) throws java.text.ParseException {
SessionFactory sessionFactory;
try {
	sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	// get the list of students
	Transaction tx = session.beginTransaction();
	Stud s=new Stud();
	session.load(s,new Long(1));	
	session.delete(s);	
	tx.commit();
	}catch (HibernateException e) {
		e.printStackTrace();
}
}
}