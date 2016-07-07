import  java.io.*;

public class  StreamApp1
{
  public  static  void  main(String args[])throws IOException
  {
     FileReader  fr=new  FileReader(args[0]);
     StreamTokenizer  tok=new StreamTokenizer(fr);
     tok.eolIsSignificant(true);
     tok.wordChars(33,130);
     boolean p=true;
     int val,cntword=0,cntnumber=0,cntdef=0;
     int cntchar=0,cntline=0;
     String s;

     while(p)
     {
       val=tok.nextToken();
       switch(val)
       {
        case  StreamTokenizer.TT_EOF:  System.out.println("EOF Encountered");
                                        p=false;

        case  StreamTokenizer.TT_EOL:   cntline++;
                                        break;
        case  StreamTokenizer.TT_WORD:  
                                        cntword++;
                                        s=tok.sval;
                                        cntchar=cntchar+s.length();
                                        break;
        case  StreamTokenizer.TT_NUMBER: 
                                        cntnumber++;
                                        break;
        default:
                System.out.println("default "+((char)val));
       }
     }
     System.out.println("No of words "+cntword);
     System.out.println("No of numbers "+cntnumber);
     System.out.println("No of  chars "+cntchar);
     System.out.println("No of lines "+cntline);
  }
}
