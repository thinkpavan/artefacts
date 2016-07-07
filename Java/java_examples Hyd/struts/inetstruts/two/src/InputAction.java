/* This is our action class which will be called by the main action servlet
(controller). This example uses dynaforms instead of our own beans to hold
form data.
*/



import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.MessageResources;
import org.apache.struts.action.DynaActionForm;

public class InputAction extends org.apache.struts.action.Action { 
    public InputAction() {    }
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("In execute method");
	  DynaActionForm df = (DynaActionForm)form;
        String firstName = (String)df.get("fname");
        String lastName = (String)df.get("lname");
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);        
        return mapping.findForward("input_fwd");
    }
}
