import data.Movie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import com.google.gson.Gson;

@WebServlet(name = "MovieServlet", urlPatterns = "/movies")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();

            Movie movie = new Movie(2, "King Kong", "1942", "Clark Gable", "Fae Dunaway", "89786", "Nope", "cheap", "Gorilla on building");

            String movieString = new Gson().toJson(movie);

            out.println(movieString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
