/*
 Shows how a layout manager lay's out components in container
 Version : 1.0
 Author : Team -J
 */
import java.awt.*;

public class INetLM implements  LayoutManager {

   public void addLayoutComponent(String name, Component comp){
		// we need not provide this , some lm's may use this to
		// keep the refernce of component with a name
		System.out.println(" in add layout component");
    }


   public  void removeLayoutComponent(Component comp){
		System.out.println(" in remove layout component");
    }


   public Dimension preferredLayoutSize(Container parent){
		System.out.println(" in preferredLayoutSize");

	// LM has to calculate this size by using it's own algorithms
	return (new Dimension(100,100));
   }
	


  public  Dimension minimumLayoutSize(Container parent){
		System.out.println(" in minimumLayoutSize");

	// LM has to calculate this size by using it's own algorithms
	return (new Dimension(100,100));
    }
   public  void layoutContainer(Container parent){
		System.out.println(" in layoutContainer");

	int nocomp = parent.getComponentCount();
	for(int i =0;i<nocomp;i++){
		Component c = parent.getComponent(i);
		// here a layout manager may invoke getmin/max/pref sizes
		// on comp/containers
		c.setSize(new Dimension(100,20));
		c.setLocation(i*100+20,50);
	}
    }
}
