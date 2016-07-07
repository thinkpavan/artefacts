/**
 * This code was automatically generated at 9:15:40 AM on Oct 16, 2003
 * by weblogic.xml.schema.binding.internal.codegen.BeanCodecGenerator -- do not edit.
 *
 * @version WebLogic Server 7.0 SP1  Mon Sep 9 22:46:58 PDT 2002 206753 
 * @author Copyright (c) 2003 by BEA Systems, Inc. All Rights Reserved.
 */

package NBDT;

// original type: ['java:NBDT']:Student


public final class StudentCodec 
  extends weblogic.xml.schema.binding.BeanCodecBase
{

  private static final int _SUPER_PROP_COUNT = 0;

  private static final weblogic.xml.stream.XMLName XML_TYPE = 
     weblogic.xml.stream.ElementFactory.createXMLName( "java:NBDT" , "Student" );



  private static final weblogic.xml.schema.binding.util.runtime.PropertyInfo[] PROPS = 
  {
  //package name = java.lang
  //class   name = String
  //java    type = java.lang.String
  //schema  name = address
  //schema  type = ['http://www.w3.org/2001/XMLSchema']:string
  //array: false primitive: false  attribute: false  formQualified: false

  new weblogic.xml.schema.binding.util.runtime.PropertyInfo(weblogic.xml.stream.ElementFactory.createXMLName(null,"address",null),
                                                            weblogic.xml.stream.ElementFactory.createXMLName("http://www.w3.org/2001/XMLSchema","string",null),
                                                            "address",
                                                            java.lang.String.class,
                                                            false,
                                                            false),


  //package name = java.lang
  //class   name = String
  //java    type = java.lang.String
  //schema  name = name
  //schema  type = ['http://www.w3.org/2001/XMLSchema']:string
  //array: false primitive: false  attribute: false  formQualified: false

  new weblogic.xml.schema.binding.util.runtime.PropertyInfo(weblogic.xml.stream.ElementFactory.createXMLName(null,"name",null),
                                                            weblogic.xml.stream.ElementFactory.createXMLName("http://www.w3.org/2001/XMLSchema","string",null),
                                                            "name",
                                                            java.lang.String.class,
                                                            false,
                                                            false),



  };


  protected Object createObject() {
    return new NBDT.Student();
  }

  protected weblogic.xml.stream.XMLName getXmlType() {
    return XML_TYPE;
  }

  protected Object invokeGetter(Object my_obj, int idx) {

    NBDT.Student typed_obj = (NBDT.Student) my_obj;
    return typedInvokeGetter(typed_obj, idx);
  }

  protected void invokeSetter(Object my_obj, int idx,
                              Object setter_arg)
  {

    NBDT.Student typed_obj = (NBDT.Student) my_obj;
    typedInvokeSetter(typed_obj, idx, setter_arg);
  }

  public int getPropertyCount()
  {
    return (_SUPER_PROP_COUNT + PROPS.length);
  }

  public weblogic.xml.schema.binding.util.runtime.PropertyInfo getPropertyInfo(int idx)
  {

    return PROPS[idx];
  }


  private static Object typedInvokeGetter(NBDT.Student my_obj, 
                                          int idx) 
  {
    Object obj;

    switch(idx) {

    case 0:
      obj = my_obj.getAddress();
      break;
    case 1:
      obj = my_obj.getName();
      break;


    default:
      throw new weblogic.utils.AssertionError("impossible case: " + idx);
    }

    return obj;

  }


  private static void typedInvokeSetter(NBDT.Student my_obj, 
                                        int idx,
                                        Object setter_arg) 
  {
    switch(idx) {

    case 0:
      my_obj.setAddress((java.lang.String)setter_arg);
      break;
    case 1:
      my_obj.setName((java.lang.String)setter_arg);
      break;


    default:
      throw new weblogic.utils.AssertionError("impossible case: " + idx);
    }

  }

  







}
