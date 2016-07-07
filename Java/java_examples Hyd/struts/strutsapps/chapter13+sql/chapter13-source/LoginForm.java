package com.oreilly.struts.storefront.security;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
/**
 * Form bean for the user signon page.
 */
public class LoginForm extends ActionForm {
  private String password = null;
  private String email = null;

  /**
   * Public accessors and mutators
   */
  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return (this.email);
  }

  public String getPassword() {
    return (this.password);
  }

  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Validate the properties that have been set from this HTTP request,
   * and return an <code>ActionErrors</code> object that encapsulates any
   * validation errors that have been found.  If no errors are found, return
   * <code>null</code> or an <code>ActionErrors</code> object with no
   * recorded error messages.
   *
   * @param mapping The mapping used to select this instance
   * @param request The servlet request we are processing
   */
  public ActionErrors validate(ActionMapping mapping,
                               HttpServletRequest request) {
    ActionErrors errors = new ActionErrors();

    if(getEmail() == null || getEmail().length() < 1) {
      errors.add( ActionErrors.GLOBAL_ERROR,
                  new ActionError("global.required", "email" ));
    }
    if(getPassword() == null || getPassword().length() < 1) {
      errors.add( ActionErrors.GLOBAL_ERROR,
                  new ActionError("global.required", "password" ));
    }
    return errors;
  }

  /**
   * Reset all properties to their default values.
   *
   * @param mapping The mapping used to select this instance
   * @param request The servlet request we are processing
   */
  public void reset(ActionMapping mapping,
                    HttpServletRequest request) {
    this.password = null;
    this.email = null;
  }
}