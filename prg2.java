import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class prg2 extends HttpServlet
  {
   public void doGet(HttpServletRequest req,HttpServletResponse res) throws   ServletException , IOException
       {
          PrintWriter out=res.getWriter();
         out.println("<HTML><BODY>Servlet Server Information ");
         out.println(" <br>Server Name: "+req.getServerName());
        out.println(" <br>Server Port: "+req.getServerPort());   
        out.println(" <br>Server Path: "+req.getServletPath());
        out.println(" <br>Client browser: "+req.getHeader("User-Agent"));
        out.println(" <br>Client Referer: "+req.getHeader("Referer"));
        out.println(" <br>Client IP: "+req.getRemoteAddr());
        out.println(" <br>Server operating system version: "+System.getProperty("os.version"));
        out.println("</BODY></HTML>");
        out.close();
    }
} 

