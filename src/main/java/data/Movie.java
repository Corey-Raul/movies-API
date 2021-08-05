package data;

public class Movie {
    private String title;
    private String rating;
    private String poster;
    private String year;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private int id;

    public Movie() {
    }

    public Movie(int id, String title, String rating, String year, String director, String actors, String poster, String genre, String plot) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.year = year;
        this.director = director;
        this.actors = actors;
        this.poster = poster;
        this.genre = genre;
        this.plot = plot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
