package handler;

import java.util.Map;
import javax.xml.rpc.handler.*;
import javax.xml.rpc.handler.HandlerInfo;
import javax.xml.rpc.handler.soap.*;
import javax.xml.rpc.*;
import javax.xml.namespace.QName;


public  class MsgCheck implements Handler
{
  private HandlerInfo hinfo;

/* called during initialization */

public void init(HandlerInfo hi) {
    hinfo= hi;
}


public void destroy() {}

public QName[] getHeaders() {
	 return hinfo.getHeaders();
}
/* called before handing over the request to web service */

public boolean handleRequest(MessageContext mc) {
    SOAPMessageContext msgContext = (SOAPMessageContext) mc;
    System.out.println("In Request: "+msgContext.getMessage().toString());
    return true;
}

/* called before sending response to client */

public boolean handleResponse(MessageContext mc) {

    SOAPMessageContext msgContext = (SOAPMessageContext) mc;

    System.out.println("In Response: "+msgContext.getMessage().toString());
    return true;
}

  /*Called if SOAP Fault is thrown
   */
public boolean handleFault(MessageContext mc) {
    SOAPMessageContext msgContext = (SOAPMessageContext) mc;

    System.out.println("In Fault: "+msgContext.getMessage().toString());
	return true;
}

}


