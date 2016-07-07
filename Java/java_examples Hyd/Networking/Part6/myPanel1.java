/* This is an implementation of a simple applet with two class files
Author : Team - J
Version : 1.0
*/

package com.inetsolv;

// import all required classes
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;


public class myPanel1 extends Panel{

 public myPanel1(){
	super();
	add(new Button("b1"));
	add(new Button("b2"));
	add(new Button("b3"));
	add(new Button("b4"));
 }
}

