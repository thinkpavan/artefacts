/* This is our action class which will be called by the main action servlet
(controller)
*/



import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.MessageResources;

public class InputAction extends org.apache.struts.action.Action { 
    public InputAction() {    }
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("In execute method");
        String firstName = ((InputPageForm)form).getfname();
        String lastName = ((InputPageForm)form).getlname();        
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);        
        return mapping.findForward("input_fwd");
    }
}
