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
    private Map<String, List<String>> directorMovieMap = new HashMap<>();


    public void addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
    }


    public void addDirector(Director director) {
        directors.put(director.getName(), director);
    }


    public void addMovieDirectorPair(String movieName, String directorName) {
        directorMovieMap.computeIfAbsent(directorName, k -> new ArrayList<>()).add(movieName);
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

    public Map<String, List<String>> getDirectorMovieMap() {
        return directorMovieMap;
    }

    public void setDirectorMovieMap(Map<String, List<String>> directorMovieMap) {
        this.directorMovieMap = directorMovieMap;
    }

    public void deleteDirectorByName(String directorName) {

        directorMovieMap.remove(directorName);

    }

    public void deleteAllDirector() {



        for(String director: directorMovieMap.keySet()) {
            List<String> moviesName = directorMovieMap.get(director);
            for(String movieName : moviesName) {
                movies.remove(movieName);
            }
            directorMovieMap.remove(director);

        }

        directors.clear();

    }
}
