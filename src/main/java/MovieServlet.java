import data.Movie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.gson.Gson;

@WebServlet(name = "MovieServlet", urlPatterns = "/movies")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");

        try {
            //get object which can write to the response
            PrintWriter out = response.getWriter();

            //eventually get movies from the database
            Movie movie = new Movie(2, "King Kong", "1942", "Clark Gable", "Fae Dunaway", "89786", "Nope", "cheap", "Gorilla on building");

            //turn into a json string
            String movieString = new Gson().toJson(movie);
            //inject into response
            out.println(movieString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");

        try {
            //get the stream of characters from the request (eventually becomes our movie)
            BufferedReader reader = request.getReader();

            // turn that stream into an array of Movies
            Movie[] movies = new Gson().fromJson(reader, Movie[].class);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
