/*Example show how to validate inputs submited by a user using form on server.
Author: Team-J
Version :1.0
Example inspried by validator examples.
*/



import java.util.Locale;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.MessageResources;



public final class ValidateAction extends Action {

    public ActionForward execute(ActionMapping mapping,
                 ActionForm form,
                 HttpServletRequest request,
                 HttpServletResponse response)
    throws Exception {
        System.out.println("In execute method");
        String b = ((ValidateForm)form).getByte();
        String s = ((ValidateForm)form).getShort();  
System.out.println("values submitted = "+ b +" ...."+s);             
        return mapping.findForward("success");
    }

}
