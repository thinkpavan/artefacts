
import java.io.RandomAccessFile;

class raf 
{
  static public void main( String args[] )
  {
    RandomAccessFile rf;
    try {
      rf = new RandomAccessFile("animals.txt", "rw");
      rf.seek( rf.length() );
      rf.writeBytes("ant bee\ncat dog\n");
      rf.close();
    }
    catch(Exception e) {
      System.out.println("Raf exception");
    }
  }
} // end of raf class