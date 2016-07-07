/*Class that implements message Driven bean
Version : 1.0
Author : Team -J
*/

package part10;
import javax.ejb.*;
import javax.jms.*;

public class mdb implements MessageDrivenBean,MessageListener {
    private MessageDrivenContext context;

// this method will be called when ejb is created

    public void ejbCreate() throws CreateException {
		System.out.println(" In Ejb create method");
    }
   public void setMessageDrivenContext(MessageDrivenContext mdc) {
	context = mdc;	
	System.out.println("In message Driven Context method");
   }
   public void ejbRemove() {
		System.out.println(" In Ejb remove method");

   }

   public void onMessage(Message msg){
	if ( msg instanceof TextMessage){
		TextMessage txt = (TextMessage) msg;
	try{
		System.out.println("message received  :"+ txt.getText());
// your code to process the message
	}catch(Exception e){
		e.printStackTrace();
	}
	}
   }


} 
