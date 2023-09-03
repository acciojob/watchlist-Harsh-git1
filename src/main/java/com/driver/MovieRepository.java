package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    private Map<String, Movie> movies = new HashMap<>();
    private Map<String, Director> directors = new HashMap<>();
    private Map<Director, List<Movie>> directorMovieMap = new HashMap<>();


    public void addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
    }


    public void addDirector(Director director) {
        directors.put(director.getName(), director);
    }


    public void addMovieDirectorPair(String movieName, String directorName) {

        Director director = directors.get(directorName);
        Movie movie = movies.get(movieName);

        directorMovieMap.computeIfAbsent(director, k -> new ArrayList<>());
        directorMovieMap.get(director).add(movie);
    }


    public Map<String, Movie> getMovies() {
        return movies;
    }

    public void setMovies(Map<String, Movie> movies) {
        this.movies = movies;
    }

    public Map<String, Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Map<String, Director> directors) {
        this.directors = directors;
    }




    public void deleteDirectorByName(String directorName) {

        List<Movie> movies = directorMovieMap.get(directors.get(directorName));
        for(Movie movie : movies) {
            this.movies.remove(movie.getName());
        }
        directorMovieMap.remove(directors.get(directorName));
        directors.remove(directorName);

    }

    public void deleteAllDirector() {

        for(Director director: directorMovieMap.keySet()) {
            List<Movie> movies = directorMovieMap.get(director);
            for(Movie movie : movies) {
                this.movies.remove(movie.getName());
            }
            directorMovieMap.remove(director);

        }
        directors.clear();

    }

    public List<String> getMoviesByDirectorName(String directorName) {

        List<Movie> movies1 = directorMovieMap.get(directors.get(directorName));
        List<String> movieList = new ArrayList<>();
        for(Movie movie: movies1) {
            movieList.add(movie.getName());
        }

        return movieList;
    }

    public List<String> findAllMovies() {
        List<String> movies1 = new ArrayList<>();
        movies1.addAll(movies.keySet());
        return movies1;
    }

    public Map<Director, List<Movie>> getDirectorMovieMap() {
        return directorMovieMap;
    }

    public void setDirectorMovieMap(Map<Director, List<Movie>> directorMovieMap) {
        this.directorMovieMap = directorMovieMap;
    }



}
