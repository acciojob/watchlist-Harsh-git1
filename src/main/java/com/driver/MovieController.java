package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName) {
        movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<String>("Success", HttpStatus.OK);

    }

    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movieName) {
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity(movie, HttpStatus.OK);
    }

    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String directorName) {

        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity(director, HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String directorName) {
        List<Movie> movies = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity(movies, HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies() {
        List<Movie> movies= movieService.findAllMovies();
        return new ResponseEntity(movies, HttpStatus.OK);
    }

    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName ) {

        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity<String>  deleteAllDirectors () {
        movieService.deleteAllDirector();
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

}
