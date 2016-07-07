
// JavaCam.java
// Downloaded from http://www.kolban.com/webcam32help/java.htm
// 24th March 1999

// Revised by Andrew Davison, 25th March 1999 (ad@cs.ait.ac.th)


import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.net.*;


public class JavaCam extends Applet 
		implements Runnable, ActionListener
{
  // parameters taken from page
  private String strUrl;       // URL of image as a string
  private int interval;        // interval between image reloads
  private int counter;        // time to next download

  private Image WebcamImage;
  private Thread loader;       // thread for loading image

  // GUI elements
  private Button reloadButton;
  private Label counterLabel;
  private TextField counterDisplay;
  private Panel infoPanel;
  

  public void init()
  {
    getParameters();
    counter = interval;

    setLayout(new BorderLayout());
    reloadButton = new Button("Try Reload");
    reloadButton.addActionListener(this);
    counterLabel = new Label("Secs to reload:");
    counterDisplay = new TextField(4);
    counterDisplay.setText(String.valueOf(interval));
    counterDisplay.setEditable(false);
    infoPanel = new Panel();
    infoPanel.add(reloadButton);
    infoPanel.add(counterLabel);
    infoPanel.add(counterDisplay);
    add(infoPanel, BorderLayout.SOUTH);
  }


  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == reloadButton) {
      stop();
      start();
    }
  }


  public void start()
  {
    if (loader == null) {
      loader = new Thread(this);
      loader.start();
    }
  }


  public void stop()
  {  
    if (loader != null) {
      loader.stop();
      loader = null;
    }
  }


  public void run()
  {
    while (true) {
      loadImage();
      counterDisplay.setText(String.valueOf(counter));
      while (counter != 0) {
        try {
          Thread.sleep(1000);    // sleep 1 sec
        }
        catch (InterruptedException e) {
          showStatus( e.toString() );
        }
        counter--;
        counterDisplay.setText(String.valueOf(counter));
      }
      counter = interval;
    }
  }


  private void loadImage()
  {
    URL ucam;
    MediaTracker mt;
    int width, height;

    try {
      ucam = new URL(strUrl);
      if (WebcamImage != null)
        WebcamImage.flush();         // to get new image
      WebcamImage = getImage(ucam); 
      mt = new MediaTracker(this);   // wait until image loaded
      mt.addImage(WebcamImage, 1);
      mt.waitForID(1);
    }
    catch (Exception e) {
       showStatus("Caught: "+ e.toString());
    }
    /*
    width = WebcamImage.getWidth(this);
    height = WebcamImage.getHeight(this);
    resize(width, height);
    */
    repaint();
  }


  public void paint(Graphics g)
  {
    if (WebcamImage != null)
      g.drawImage(WebcamImage, 0, 0, this);
  }


  private void getParameters()
  {
    String parameter;

    strUrl = getParameter("URL");
    if (strUrl == null) {
      showStatus("No image URL supplied");
      destroy();
    }
    parameter = getParameter("Interval");
    if (parameter == null)
      interval = 30;     // default is download every 30 secs
    else
      interval = Integer.parseInt(parameter);
  }

} // end of JavaCam.java
