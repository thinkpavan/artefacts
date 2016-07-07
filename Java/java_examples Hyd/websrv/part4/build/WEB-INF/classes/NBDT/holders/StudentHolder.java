/**
 * This code was automatically generated at 9:15:40 AM on Oct 16, 2003
 * by weblogic.xml.schema.binding.internal.codegen.HolderGenerator -- do not edit.
 *
 * @version WebLogic Server 7.0 SP1  Mon Sep 9 22:46:58 PDT 2002 206753 
 * @author Copyright (c) 2003 by BEA Systems, Inc. All Rights Reserved.
 */

package NBDT.holders;


public final class StudentHolder 
  implements weblogic.xml.schema.binding.Holder
{

  public NBDT.Student value;

  public StudentHolder() {}

  public StudentHolder(NBDT.Student value) {
    this.value = value;
  } 


  public Object getValue() {
    return value;
  }

  public void setValue(Object obj) {
    this.value = (NBDT.Student) obj;
  }
}
