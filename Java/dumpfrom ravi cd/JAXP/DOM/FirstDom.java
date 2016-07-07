import javax.xml.parsers.*;
import org.w3c.dom.*;
public class FirstDom{
        public static void main(String args[]){
                try{
		      DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            	DocumentBuilder db=dbf.newDocumentBuilder();
      	      Document d=db.parse("empdetails.xml");
	            Node root=d.getDocumentElement();
			System.out.println("RootElement Name is"+root.getNodeName());
			if(root.hasChildNodes()){
				System.out.println(root.getNodeName()+"Has Childs");
				NodeList nl=root.getChildNodes();
				System.out.println(root.getNodeName()+" Has "+nl.getLength()+"Child Nodes That Are....");
				Test t=new Test();
				for(int i=0;i<nl.getLength();i++){
					t.printNode(nl.item(i));
				}
			}
		}catch(Exception e){System.out.println("Exception"+e);}
}
}
class Test{	
		public void printNode(Node node){
				switch(node.getNodeType()){
					case Node.ELEMENT_NODE:
						System.out.println("Element Node Type"+node.getNodeName());
						if(node.hasChildNodes()){
							NodeList nl1=node.getChildNodes();
							for(int i=0;i<nl1.getLength();i++){
								printNode(nl1.item(i));
								}
							}
						break;
					case Node.TEXT_NODE:
						System.out.println("Text Node Name is"+node.getNodeName()+"Value is"+node.getNodeValue());
						break;
					default:
						System.out.println("SoMe Other Node  Name is"+node.getNodeName()+"Value is"+node.getNodeValue());					
				}
			}
	}		

 

