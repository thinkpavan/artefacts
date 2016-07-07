/* Prgram to send messages to queue
Author : Team -J
Version : 1.0
Note: Adopted from weblogic examples.
*/

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QSender
{

  String connfactname="jmsconfact";
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
	  System.out.println("Start");
    InitialContext ic = getInitialContext();
    System.out.println(ic);
    QSender qs = new QSender();
    System.out.println(" Trying to initialize the Qsender");
    qs.init(ic, "jmsqueue1" +
    		"");
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
 		h.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            h.put(Context.PROVIDER_URL, "t3://localhost:7001");
//            h.put(Context.SECURITY_PRINCIPAL, "weblogic");//user
//            h.put(Context.SECURITY_CREDENTIALS, "weblogic"); 
	      return new InitialContext(h);
  }
}

