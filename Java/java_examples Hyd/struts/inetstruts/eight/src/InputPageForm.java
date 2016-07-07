/*
InputPageForm to hold the data submitted by the user ( This is a java bean).
*/


import javax.servlet.http.*;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class InputPageForm extends org.apache.struts.action.ActionForm {
    
    private String fn;
    private String ln;
    
    public InputPageForm() {
 	
    }
    
    public void reset(ActionMapping actionMapping, HttpServletRequest request) {
	System.out.println("Now reset method is called");
        this.fn = null;
        this.ln  = null;
    }
    /* This is used to validate the inputs submitted*/
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
	   System.out.println("Now I am validating inputs");
	   ActionErrors actionErrors = new ActionErrors();
	   
	   if ( this.fn == null || this.fn.length() == 0) {
	      actionErrors.add("firstName", new ActionError("error.firstName"));
	   }
	   if ( this.ln == null || this.ln.length() == 0) {
	      actionErrors.add("lastName", new ActionError("error.lastName"));
	   } 
	   return actionErrors;
    }
    public void setfname ( String s ) {
       this.fn = s;
    }
    public void setlname ( String s ) {
       this.ln = s;
    }

    public String getfname () {
       return this.fn;
    }
    public String getlname () {
       return this.ln;
    }
}
