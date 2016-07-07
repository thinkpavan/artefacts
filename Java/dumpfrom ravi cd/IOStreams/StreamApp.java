import  java.io.*;

public class  StreamApp
{
  public  static  void  main(String args[])throws IOException
  {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     StreamTokenizer  tok=new StreamTokenizer(br);
     tok.eolIsSignificant(true);
     tok.wordChars(34,130);
     boolean p=true;
     int val,cntword=0,cntnumber=0,cntdef=0;
     while(p)
     {
       val=tok.nextToken();
       switch(val)
       {
        case  StreamTokenizer.TT_EOF:   System.out.println("EOF Encountered");
                        break;
        case  StreamTokenizer.TT_EOL:   System.out.println("EOL encountered"+tok.lineno());
                        break;
        case  StreamTokenizer.TT_WORD:  System.out.println("Word "+tok.sval);
                        cntword++;
                        break;
        case  StreamTokenizer.TT_NUMBER:  System.out.println("Number "+tok.nval);
                        cntnumber++;
                        break;
        default:
                System.out.println("default "+((char)val));
                cntdef++;
              if(val==(char)'!')p=false;
       }
     }
     System.out.println("No of words "+cntword);
     System.out.println("No of numbers "+cntnumber);
     System.out.println("No of def chars "+cntdef);
  }
}
