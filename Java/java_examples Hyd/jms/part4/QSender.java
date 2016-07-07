/* Prgram to send messages to queue
Author : Team -J
Version : 1.0
*/

import java.io.*;
import java.util.*;
import javax.transaction.*;
import javax.naming.*;
import javax.jms.*;

public class QSender
{

  String connfactname="jmsfact1";
  QueueConnectionFactory qconFact;
  QueueConnection qcon;
  QueueSession qsession;
  QueueSender qsender;
  Queue queue;
  TextMessage msg;



  public void init(Context ctx, String queueName)
       throws NamingException, JMSException
  {
/* get the connection and create the connection object*/
    qconFact = (QueueConnectionFactory) ctx.lookup(connfactname);
    qcon = qconFact.createQueueConnection();
/* using connection create a non transactional session */
    qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
/* look up for the destination ie queue */
    queue = (Queue) ctx.lookup(queueName);
    qsender = qsession.createSender(queue);
    //qsender.setDeliveryMode(DeliveryMode.NON_PERSISTENT); 
    qsender.setDeliveryMode(DeliveryMode.PERSISTENT ); 

    msg = qsession.createTextMessage();
    qcon.start();
  }

  /**
   * Sends a message to a JMS queue.
   *
   * @params message  message to be sent
   * @exception JMSException if JMS fails to send message due to internal error
   */
  public void send(String message)
       throws JMSException
  {
    msg.setText(message);
    qsender.send(msg);
  }

  /**
   * Closes JMS objects.
   * @exception JMSException if JMS fails to close objects due to internal error
   */
  public void close()
       throws JMSException
  {
    qsender.close();
    qsession.close();
    qcon.close();
  }


  public static void main(String[] args)
       throws Exception
  {
    InitialContext ic = getInitialContext();
    QSender qs = new QSender();
    System.out.println(" Trying to initialize the Qsender");
    qs.init(ic, "jmsqueue1");
	int i;
	System.out.println("Sending messages: Hit enter to start sending msgs");
	System.in.read();
	String msg = " Message No  ";
	for(i=0;i<10;i++)
        qs.send(msg + i);
	System.out.println("Messages Sent");
    qs.close();
  }

  private static InitialContext getInitialContext()
       throws NamingException
  {
            Hashtable h = new Hashtable();
 		h.put(Context.INITIAL_CONTEXT_FACTORY,
                "weblogic.jndi.WLInitialContextFactory");
            h.put(Context.PROVIDER_URL, "t3://localhost:7001");
            h.put(Context.SECURITY_PRINCIPAL, "admin");//user
            h.put(Context.SECURITY_CREDENTIALS, "inetadmin"); 
	      return new InitialContext(h);
  }

}

