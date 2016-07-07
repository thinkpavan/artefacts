/* Program to receive  messages from the  queue
Author : Team -J
Version : 1.0
Note: Adopted from weblogic examples.
*/


import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class QReceiver implements MessageListener
{
  String connfactname="jmsconfact";
  QueueConnectionFactory qconFact;
  QueueConnection qcon;
  QueueSession qsession;
  QueueReceiver qreceiver;
  Queue queue;
  TextMessage msg;
  int msgno=0;



  // MessageListener interface method , called when there is a message.
  public void onMessage(Message msg)
  {
    try {
      String rmsg;
//as there are different types of msg's we are testing it here.
      if (msg instanceof TextMessage) {
        rmsg= ((TextMessage)msg).getText();
      } else {
        rmsg= msg.toString();
      }
	msgno ++;
      System.out.println("Message Received: "+ rmsg +"msgno..."+ msgno);

      if (msgno == 10) {
        synchronized(this) {
		System.out.println("Notifying the main thread");
          this.notifyAll(); // Notify main thread to quit
        }
      }
    } catch (JMSException jmse) {
      jmse.printStackTrace();
    }
  }


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
    qreceiver = qsession.createReceiver(queue);
    qreceiver.setMessageListener(this);
    qcon.start();
  }

  public void close()
       throws JMSException
  {
    qreceiver.close();
    qsession.close();
    qcon.close();
  }

  public static void main(String[] args)
       throws Exception
  {

    InitialContext ic = getInitialContext();
    QReceiver qr = new QReceiver();
    System.out.println(" Trying to initialize the QReceiver");
    qr.init(ic, "jmsqueue1");
    System.out.println("Receiving messages");

     synchronized(qr) {
      while (true) {
        try {
          qr.wait(); // waits till we get notification
		System.out.println(" Stoping the main thread");
	      qr.close();
		System.exit(0);
        } catch (InterruptedException ie) {}
      }
    }
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




