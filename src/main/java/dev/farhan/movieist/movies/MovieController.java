package dev.farhan.movieist.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(service.findMovieByImdbId(imdbId), HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<Optional<Movie>> getSingleMovieByDate(@PathVariable String date){
        return new ResponseEntity<Optional<Movie>>(service.findMovieByReleaseDate(date), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Optional<List<Movie>>> getSingleMovieByTitle(@PathVariable String title){
        return new ResponseEntity(service.findMovieByTitle(title), HttpStatus.OK);
    }
}
