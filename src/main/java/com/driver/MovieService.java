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

    public List<String> getMoviesByDirectorName(String directorName) {

        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String directorName) {
        movieRepository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirector() {
        movieRepository.deleteAllDirector();
    }

}
