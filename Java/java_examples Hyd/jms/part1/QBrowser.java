/* Program to browse the messages in the queue.
Author : Team -J
Version : 1.0
Note: Adopted from weblogic examples.
*/
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class QBrowser
{
  String connfactname="jmsconfact";
  QueueConnectionFactory qconFact;
  QueueConnection qcon;
  QueueSession qsession;
/* in place of receiver we are using qbrowser here.*/
  private QueueBrowser qbrowser;
  private Queue queue;

   public void init(Context ctx, String queueName) throws NamingException, JMSException
  {
/* get the connection and create the connection object*/
    qconFact=(QueueConnectionFactory) ctx.lookup(connfactname);
    qcon=qconFact.createQueueConnection();
/* using connection create a non transactional session */
    qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
/* look up for the destination ie queue */
    queue = (Queue) ctx.lookup(queueName);
// we are using qbrowser here
    qbrowser = qsession.createBrowser(queue);
    qcon.start();
  } 

  public void displayQueue()
       throws JMSException
  {
    Enumeration e = qbrowser.getEnumeration(); // gets list of messages.
    Message m = null;

    if (! e.hasMoreElements()) {
      System.out.println("There are no messages on this queue.");
    } else {

      while (e.hasMoreElements()) {
        m = (Message) e.nextElement();// display header
        System.out.println("Message ID " + m.getJMSMessageID() +
                           " delivered " + new Date(m.getJMSTimestamp()) +
                           " to " + m.getJMSDestination());
        System.out.println("\tMessage type   " + m.getJMSType());
        if (m instanceof TextMessage) {
          System.out.println("\tTextMessage    \"" + ((TextMessage)m).getText() + "\"");
        }
      }
    }
  }

  public void close()
       throws JMSException
  {
    qbrowser.close();
    qsession.close();
    qcon.close();
  }


  public static void main(String[] args)
       throws Exception
  {
    InitialContext ic = getInitialContext();
    QBrowser qb = new QBrowser();
    System.out.println(" Trying to initialize the QBrowser");
    qb.init(ic, "jmsqueue1");
    qb.displayQueue();
    qb.close();
  }

  private static InitialContext getInitialContext()
       throws NamingException
  {
            Hashtable h = new Hashtable();
 		h.put(Context.INITIAL_CONTEXT_FACTORY,
                "weblogic.jndi.WLInitialContextFactory");
            h.put(Context.PROVIDER_URL, "t3://localhost:7001");
            h.put(Context.SECURITY_PRINCIPAL, "admin");//user
            h.put(Context.SECURITY_CREDENTIALS, "admin"); 
	      return new InitialContext(h);
  }

}




