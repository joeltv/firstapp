package Les1.practicum2.copy;

import java.net.Socket;
import java.io.*;
import java.util.*;



public class Client {
	public String str;
    public static void main(String[] args) throws Exception {
      Socket s = new Socket("localhost", 4750);
      Scanner scanner = new Scanner(System.in);
      String myString = scanner.nextLine();
      OutputStream os = s.getOutputStream();
     PrintWriter pw = new PrintWriter(os);		  	
      while (!myString.equals("stop")){
    	  pw.println(myString);
          pw.flush();
    	  myString = scanner.nextLine();
      }
    	  

      pw.println("Roger");

      s.close();
      scanner.close();
    }
  }