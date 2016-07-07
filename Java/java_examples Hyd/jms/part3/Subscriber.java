/* shows how to subscribe to a topic.
Version : 1.0
Author : Team -J
*/

import java.io.*;
import java.util.*;
import javax.transaction.*;
import javax.naming.*;
import javax.jms.*;

public class Subscriber
  implements MessageListener
{
  String connfactname="jmsfact1";
  TopicConnectionFactory tconFactory;
  TopicConnection tcon;
  TopicSession tsession;
  TopicSubscriber tsubscriber;
  Topic topic;
  int msgno=0;

  // MessageListener interface
  public void onMessage(Message msg)
  {
    try {
      String msgText;

      if (msg instanceof TextMessage) {
        msgText = ((TextMessage)msg).getText();
      } else {
        msgText = msg.toString();
      }
      msgno++;
      System.out.println(msgText);
System.in.read();
System.in.read();
	msg.acknowledge();
      if (msgno == 5 ){
        synchronized(this) {
          this.notifyAll(); // Notify main thread to quit
        }
      }
    } catch (Exception jmse) {
      jmse.printStackTrace();
    }
  }


  public void init(Context ctx, String topicName)
       throws NamingException, JMSException
  {
    tconFactory = (TopicConnectionFactory) ctx.lookup(connfactname);
    tcon = tconFactory.createTopicConnection();
    tsession = tcon.createTopicSession(false, Session.CLIENT_ACKNOWLEDGE);
    topic = (Topic) ctx.lookup(topicName);
    tsubscriber = tsession.createSubscriber(topic);
    tsubscriber.setMessageListener(this);
    tcon.start();
  }


  public void close()
       throws JMSException
  {
    tsubscriber.close();
    tsession.close();
    tcon.close();
  }

  public static void main(String[] args)
       throws Exception
  {
    InitialContext ic = getInitialContext();
    Subscriber s = new Subscriber();
    s.init(ic,"jmstopic1");

    System.out.println("Ready To Receive Messages ");

    // Wait until a "quit" message has been received.
    synchronized(s) {
      while (true) {
        try {
          s.wait();
	    System.out.println("Received message, Now quiting");
	    s.close();
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
            h.put(Context.SECURITY_CREDENTIALS, "inetadmin"); 
	      return new InitialContext(h);
  }

}



