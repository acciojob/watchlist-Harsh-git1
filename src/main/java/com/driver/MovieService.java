package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {

        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {

        movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    public Director getDirectorByName(String directorName) {

        return movieRepository.getDirectors().get(directorName);
    }

    public Movie getMovieByName(String movieName) {

        return movieRepository.getMovies().get(movieName);
    }

    public List<Movie> getMoviesByDirectorName(String directorName) {

        Map<String, List<String>> moviesMap = movieRepository.getDirectorMovieMap();
        Map<String, Movie> movies = movieRepository.getMovies();

        List<Movie> movies1 = new ArrayList<>();
        List<String> movieList = moviesMap.get(directorName);

        for(String movie : movieList) {
            movies1.add(movies.get(movie));
        }

        return movies1;
    }

    public List<Movie> findAllMovies() {
        Map<String, Movie> movies = movieRepository.getMovies();
        List<Movie> movies1 = new ArrayList<>();

        movies1.addAll(movies.values());
        return movies1;
    }

    public void deleteDirectorByName(String directorName) {

        movieRepository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirector() {

        movieRepository.deleteAllDirector();
    }

}
