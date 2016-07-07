/* This shows how to create our own data types to be passed as
args to web service.
Author : Team -J
Version : 1.0
*/


package NBDT;

import NBDT.Student;
public class WS4{
  public Student method1(Student s) {
    	s.printData();
	s.setName("set by Webservice");
	return s;
  }
}
