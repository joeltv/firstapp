package Les1.practicum2.copy;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.InputStream;

public class Server {
	  public static void main(String[] arg) throws Exception {
	    ServerSocket ss = new ServerSocket(4750);
	    Socket s = ss.accept();
	    InputStream is = s.getInputStream();

	    Scanner sc = new Scanner(is);
	    while (sc.hasNextLine()) {
	      System.out.print(sc.nextLine());
	    } 
	   
	    s.close();
	    ss.close();
	    sc.close();
	  }
	}
