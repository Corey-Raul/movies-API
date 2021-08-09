import com.google.gson.Gson;
import data.DaoFactory;
import data.Movie;
import data.MoviesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

@WebServlet(name = "MovieServlet", urlPatterns = "/movies")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            //get object which can write to the
            PrintWriter out = response.getWriter();
            //Eventually get movies from database
//            Movie movie = new Movie(2, "King Kong", 5, 2007, "Jack Black", "Jack Black", "none", "cool", "plot goes here");

            //Turn into json string
            MoviesDao moviesDao = DaoFactory.getMoviesDao(DaoFactory.ImplType.MYSQL);
            String movieString = new Gson().toJson(moviesDao.all());

//            inject into response
            out.println(movieString);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        PrintWriter out = null;
        try {
            out = response.getWriter();

            //Basically a stream of characters
            BufferedReader reader = request.getReader(); //Whats is being sent across is 0s and 1s ("Stream of 0s and 1s, as it is reading it, the buffer will attempt to translate it to a character array, we can take that stream and try to convert it to a movie array

            //Turn that stream of characters into array of movies
            //It will take a BufferedReader and attempts to convert that stream into an array of movies
            Movie[] movies = new Gson().fromJson(reader, Movie[].class); //Movie[].class is Providing a definition of what this object is (A blueprint)
            DaoFactory
                    .getMoviesDao(DaoFactory.ImplType.MYSQL)
                    .insertAll(movies);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //write a meaningful response body and set the status code to 200
        out.println(new Gson().toJson("{message: \"Movies POST was successful\"}"));
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        PrintWriter out = null;

        try {
            out = response.getWriter();
            BufferedReader reader = request.getReader();

            //'Where am I getting it from and what am I trying to turn it into?
            //Getting it from 'reader' and trying to turn it into Movie objects
            Movie movie = new Gson().fromJson(reader, Movie.class);

            DaoFactory.getMoviesDao(DaoFactory.ImplType.MYSQL).update(movie);
//            moviesDao.update(movie);

        } catch (Exception e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(500);
            e.printStackTrace();
            return;
        }

        out.println(new Gson().toJson("{message: \"Movie was updated successfully\"}"));
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            BufferedReader reader = request.getReader();

            int id = new Gson().fromJson(reader, int.class);
            DaoFactory.getMoviesDao(DaoFactory.ImplType.MYSQL).destroy(id);

            System.out.println("The movie ID was " + id);


        } catch (Exception e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(500);
            e.printStackTrace();
            return;
        }

        out.println(new Gson().toJson("message: \"Movie Deleted Successfully\""));
        response.setStatus(200);

    }


}
