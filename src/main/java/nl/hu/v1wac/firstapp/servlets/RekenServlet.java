package nl.hu.v1wac.firstapp.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/RekenServlet.do")
public class RekenServlet extends HttpServlet {
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws ServletException, IOException {
 String g1 = req.getParameter("getal1");
 int getal1 = Integer.parseInt(g1);
 String g2 = req.getParameter("getal2");
 int getal2 = Integer.parseInt(g2);
 String delen = req.getParameter("delen");
 String vermenigvuldigen = req.getParameter("vermenigvuldigen");
 String optellen = req.getParameter("optellen");
 String aftrekken = req.getParameter("aftrekken");

 PrintWriter out = resp.getWriter();
 resp.setContentType("text/html");
 out.println("<!DOCTYPE html>");
 out.println("<html>");
 out.println(" <title>Dynamic Example</title>");
 out.println(" <body>");
 out.println(" <h2>Dynamic webapplication example</h2>");
 if(delen != null){
	 out.println(getal1 + " " + delen + " " + getal2 + " " + "=" + " " + getal1 / getal2 );
 }
 if(vermenigvuldigen != null){
 out.println(getal1 + " " + vermenigvuldigen + " " + getal2 + " " + "=" + " " + getal1 * getal2 );
 }
 if(optellen != null){
 out.println(getal1 + " " + optellen + " " + getal2 + " " + "=" + " " + (getal1 + getal2) );
 }
 if(aftrekken != null){
 out.println(getal1 + " " + aftrekken + " " + getal2 + " " + "=" + " " + (getal1 - getal2) );
 }
 out.println(" </body>");
 out.println("</html>");
 }
}