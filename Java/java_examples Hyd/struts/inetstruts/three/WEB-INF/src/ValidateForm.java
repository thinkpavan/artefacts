/*Example show how to validate inputs submited by a user using form on server.
Author: Team-J
Version :1.0
Example inspried by validator examples.
*/



import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
/* instead of creating a class as subclass of ActionForm, we need to create 
it as subclass of ValidatorForm to use validation framework.
*/

public class ValidateForm extends ValidatorForm implements Serializable {
    private String action = null;

    private String sByte = null;
    private String sShort = null;
    private String sInteger = null;
    private String sLong = null;
    private String sFloat = null;
    private String sFloatRange = null;
    private String sDouble = null;
    private String sDate = null;

    public String getAction() {
	return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public String getByte() {
       return sByte;
    }

    public void setByte(String sByte) {
       	this.sByte = sByte;
    }

    public String getShort() {
       return sShort;
    }

    public void setShort(String sShort) {
       	this.sShort = sShort;
    }

    public String getInteger() {
       return sInteger;
    }

    public void setInteger(String sInteger) {
       	this.sInteger = sInteger;
    }

    public String getLong() {
       return sLong;
    }

    public void setLong(String sLong) {
       	this.sLong = sLong;
    }

    public String getFloat() {
       return sFloat;
    }

    public void setFloat(String sFloat) {
       	this.sFloat = sFloat;
    }

    public String getFloatRange() {
       return sFloatRange;
    }


    public void setFloatRange(String sFloatRange) {
          this.sFloatRange = sFloatRange;
    }

    public String getDouble() {
       return sDouble;
    }

    public void setDouble(String sDouble) {
       	this.sDouble = sDouble;
    }

    public String getDate() {
       return sDate;
    }

    public void setDate(String sDate) {
       	this.sDate = sDate;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
System.out.println("Reset in validate form called");
       action = null;
       sByte = null;
       sShort = null;
       sInteger = null;
       sLong = null;
       sFloat = null;
       sFloatRange = null;
       sDouble = null;
       sDate = null;
    }
}
