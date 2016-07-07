/* shows how to create a stub dynamically without using wsdl and invoke
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

public class Client2 {
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
	    QName operationName1 = new QName("http://www.inet.com/webservices/jc/","method1");
	    QName operationName2 = new QName("http://www.inet.com/webservices/jc/","method2");

	    //service created without wsdl
    	    Service service = factory.createService(serviceName);
          // create call
          Call call = service.createCall();
          // set port and operation name
          call.setPortTypeName(portName);
/* make a call to method1 *******************************/
          call.setOperationName(operationName1);
          // add parameters
          call.addParameter("string", 
                      new QName("http://www.w3.org/2001/XMLSchema", "string"), 
                      ParameterMode.IN);
	    call.setReturnType(new QName( "http://www.w3.org/2001/XMLSchema","string") );
          call.setTargetEndpointAddress("http://localhost:7001/jc/pjws");
          // invoke the remote web service
          String res = (String) call.invoke(new Object[] {"dynamic call invocation"});
	    System.out.println("result =  "+ res);
/* make a call to method2 *******************************/
          call.setOperationName(operationName2);
          // add one more parameter
          call.addParameter("string0", 
                      new QName("http://www.w3.org/2001/XMLSchema", "string"), 
                      ParameterMode.IN);
	    call.setReturnType(new QName( "http://www.w3.org/2001/XMLSchema","string") );
          call.setTargetEndpointAddress("http://localhost:7001/jc/pjws");
          // invoke the remote web service
          res = (String) call.invoke(new Object[] {"param1","param2"});
	    System.out.println("result of method2=  "+ res);
	 }
} 
