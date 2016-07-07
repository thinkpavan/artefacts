/* shows how to publish to a topic.
Version : 1.0
Author : Team -J
*/

import java.io.*;
import java.util.*;
import javax.transaction.*;
import javax.naming.*;
import javax.jms.*;


public class Publisher
{
  String connfactname="jmsfact1";
  TopicConnectionFactory tconFactory;
  TopicConnection tcon;
  TopicSession tsession;
  TopicPublisher tpublisher;
  Topic topic;
  TextMessage msg;

  public void init(Context ctx, String topicName)
       throws NamingException, JMSException
  {
    tconFactory = (TopicConnectionFactory) ctx.lookup(connfactname);
    tcon = tconFactory.createTopicConnection();
    tsession = tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
    topic = (Topic) ctx.lookup(topicName);
    tpublisher = tsession.createPublisher(topic);
    msg = tsession.createTextMessage();
    tcon.start();
  }


  public void send(String message)
       throws JMSException
  {

    msg.setText(message);
    tpublisher.publish(msg);
  }


  public void close()
       throws JMSException
  {
    tpublisher.close();
    tsession.close();
    tcon.close();
  }


  public static void main(String[] args)
       throws Exception
  {

    InitialContext ic = getInitialContext();
    Publisher pb = new Publisher ();
System.out.println(" Initialising publisher");
    pb.init(ic, "jmstopic1");
    Send(pb);
System.out.println("Messages sent");
    pb.close();
  }

  protected static void Send(Publisher p)
       throws IOException, JMSException
  {
    String line="Topic message";
    int i=0;
    for(i=0;i<5;i++)
            p.send(line);
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

