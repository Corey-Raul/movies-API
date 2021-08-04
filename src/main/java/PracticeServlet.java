import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet (name = "Practice Servlet", urlPatterns = "/practice-servlet")
public class PracticeServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        try{
            PrintWriter out = response.getWriter();
            out.println("This is practicing servlets");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}