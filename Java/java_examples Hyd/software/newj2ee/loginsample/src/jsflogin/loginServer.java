/*
 * @(#)loginServer.java
 *
 * Copyright 2003 Chris Schalk
 * All rights reserved.
 *
 */



package jsflogin;


public class loginServer extends Object
  { 


  String userid;
  String password;


  public String getUserid()
  {
    return userid;
  }

  public void setUserid(String newUserid)
  {
    userid = newUserid;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String newPassword)
  {
    password = newPassword;
  }







  public String loginAction() 
   {

System.out.println("in action...");
System.out.println("userid = " + userid );
System.out.println("password = " + password );

//Check to see if login credentials are successful


if ( userid.equals("scott")  && password.equals("tiger") )
{
System.out.println("returning success");
        return "success";
}
       else 
        {
System.out.println("returning failure");
       return "failure"; 
        }


   }






  }