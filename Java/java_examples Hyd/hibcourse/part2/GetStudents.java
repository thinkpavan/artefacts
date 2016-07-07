import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.cfg.Configuration;
import java.util.*;
public class GetStudents {
public static void main(String[] args) throws java.text.ParseException {
SessionFactory sessionFactory;
try {
	sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	// get the list of students
	Transaction tx = session.beginTransaction();
						
	List students = session.find("from Stud");
			
	tx.commit();
	for (int i = 0; i<students.size(); i++) {
		Stud s = (Stud) students.get(i);
		System.out.println("name ="+s.getName());
		System.out.println("address ="+s.getAddress());
		System.out.println("father name ="+s.getFatherName());
		System.out.println("*******************************");
	}
	
} catch (HibernateException e) {
		e.printStackTrace();
}
}
}