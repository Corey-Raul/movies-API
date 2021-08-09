package data;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.List;

public class MySqlMoviesDao implements MoviesDao{

    private Connection connection = null;

    public MySqlMoviesDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());

            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        }  catch(SQLException sqlException){
            throw new RuntimeException("Error Connecting to Database", sqlException);
        }

    }

    @Override
    public List<Movie> all() throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM movies");

        PreparedStatement statement = connection.prepareStatement(sql.toString());

        statement.executeUpdate();

        return null;
    }

    @Override
    public Movie findOne(int id) {
        return null;
    }

    @Override
    public void insert(Movie movie) throws SQLException {
//        StringBuilder sql = new StringBuilder("INSERT INTO movies (" +
//                "title, rating, poster, year, genre, director, plot, actors, id) " +
//                "VALUE ");
//
//        sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?)");
//
//        PreparedStatement statement = connection.prepareStatement(sql.toString());
//
//        statement.setString(1, movie.getTitle());
//        statement.setString(2, movie.getRating());
//        statement.setString(3, movie.getPoster());
//        statement.setString(4, movie.getYear());
//        statement.setString(5, movie.getGenre());
//        statement.setString(6, movie.getDirector());
//        statement.setString(7, movie.getPlot());
//        statement.setString(8, movie.getActors());
//        statement.setInt(9, movie.getId());
//
//        statement.executeUpdate();
    }

    @Override
    public void insertAll(Movie[] movies) throws SQLException {

        // Build sql template
        StringBuilder sql = new StringBuilder("INSERT INTO movies (" +
                "title, rating, poster, year, genre, director, plot, actors, id) " +
                "VALUES ");


        // Add a interpolation template for each element in movies list
        sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?), ".repeat(movies.length));

        // Create a new String and take off the last comma and whitespace
        sql = new StringBuilder(sql.substring(0, sql.length() - 2));

        // Use the sql string to create a prepared statement
        //Represents a precompiled SQL statement
        PreparedStatement statement = connection.prepareStatement(sql.toString());

        // Add each movie to the prepared statement using the index of each sql param: '?'
        // This is done by using a counter
        // You could use a for loop to do this as well and use its incrementor
        int counter = 0;
        for (Movie movie : movies) {
            statement.setString((counter * 9) + 1, movie.getTitle());
            statement.setString((counter * 9) + 2, movie.getRating());
            statement.setString((counter * 9) + 3, movie.getPoster());
            statement.setString((counter * 9) + 4, movie.getYear());
            statement.setString((counter * 9) + 5, movie.getGenre());
            statement.setString((counter * 9) + 6, movie.getDirector());
            statement.setString((counter * 9) + 7, movie.getPlot());
            statement.setString((counter * 9) + 8, movie.getActors());
            statement.setInt((counter * 9) + 9, movie.getId());
            counter++;
        }
        statement.executeUpdate();
    }

    @Override
    public void update(Movie movie) throws SQLException {
        String sql = "UPDATE movies " +
                "SET title = ?, rating = ?, poster = ?, year = ?, genre = ?, director = ?, plot = ?, actors = ? " +
                "WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, movie.getTitle());
        statement.setString(2, movie.getRating());
        statement.setString(3, movie.getPoster());
        statement.setString(4, movie.getYear());
        statement.setString(5, movie.getGenre());
        statement.setString(6, movie.getDirector());
        statement.setString(7, movie.getPlot());
        statement.setString(8, movie.getActors());
        statement.setInt(9, movie.getId());

        statement.executeUpdate();
    }

    @Override
    public void destroy(int id) throws SQLException {
        String sql = "DELETE FROM movies " +
                "WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.execute();
    }
}