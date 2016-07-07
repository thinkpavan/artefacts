/* calls methods of webservice.
Version : 1.0
Author : Team-J
*/

import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Service;
import javax.xml.rpc.Call;
import javax.xml.rpc.ParameterMode;
import javax.xml.namespace.QName;


public class Client{
  
  public static void main( String[] args ) throws Exception {

  // Setup the global JAX-RPC service factory
  System.setProperty( "javax.xml.rpc.ServiceFactory",
    "weblogic.webservice.core.rpc.ServiceFactoryImpl");
			  
  ServiceFactory factory = ServiceFactory.newInstance();
  
  //define qnames
  String targetNamespace = "http://www.inet.com/mdb";

  QName serviceName = new QName( targetNamespace, "mdb" );
  QName portName = new QName( targetNamespace, "mdbPort" );

  //create service
  Service service = factory.createService( serviceName ); 

  //create outbound call
  Call call = service.createCall();

  QName operationName = new QName( targetNamespace, "submit" );

  //set port and operation name
  call.setPortTypeName( portName );
  call.setOperationName( operationName );

  //add parameters
  call.addParameter( "param", 
	new QName( "http://www.w3.org/2001/XMLSchema", "string" ), ParameterMode.IN );

  //set end point address
  call.setTargetEndpointAddress( 
	"http://localhost:7001/mdb/mdb" );

	  String result = (String)call.invoke( new Object[]{ "Param from Client*****" } );
System.out.println("Result =  "+ result);
  }
}

