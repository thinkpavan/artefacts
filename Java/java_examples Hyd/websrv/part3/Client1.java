/* shows how to create a stub dynamically using wsdl and invoke
operations on the webservice.
Author : Team - J
Version : 1.0
Note: check wsdl file for the element 
     <soap:address location > before client.

*/

package PJWS;
import PJWS.*;

import java.net.URL;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Service;
import javax.xml.rpc.Call;
import javax.xml.rpc.ParameterMode;
import javax.xml.namespace.QName;

public class Client1 {
	 public static void main(String[] args) throws Exception{

    // Setup the global JAXM message factory
    System.setProperty("javax.xml.soap.MessageFactory",
      "weblogic.webservice.core.soap.MessageFactoryImpl");
    // Setup the global JAX-RPC service factory
    System.setProperty( "javax.xml.rpc.ServiceFactory",
      "weblogic.webservice.core.rpc.ServiceFactoryImpl");
	    // create service factory
	    ServiceFactory factory = ServiceFactory.newInstance();
	    System.out.println("factory = "+factory);
	    // target namespace,servicename.
	    QName serviceName = new QName("http://www.inet.com/webservices/jc/","pjws");
	    // target namespace,portname
    	    QName portName = new QName("http://www.inet.com/webservices/jc/","pjwsPort");
	    URL wsdlLocation = new URL("http://localhost:7001/pjws.wsdl");
	    // create service
    	    Service service = factory.createService(wsdlLocation,serviceName);
          // create a stub (client side proxy) dynamically.
	       PJWS.PJWSIF proxy = (PJWS.PJWSIF ) service.getPort(portName,PJWS.PJWSIF.class); 
	       System.out.println("Proxy class = "+ proxy);
	       System.out.println("method1 res =  " + proxy.method1("Dyn Proxy"));
	       System.out.println("method2 res =  " + proxy.method2("DynProxy","******"));

	 }
} 
