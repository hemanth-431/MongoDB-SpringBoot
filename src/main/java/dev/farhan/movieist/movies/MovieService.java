package dev.farhan.movieist.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }
    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }

    public Optional<Movie> findMovieByReleaseDate(String date) {
        return repository.findMovieByReleaseDate(date);
    }

    public Optional<List<Movie>> findMovieByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").regex(title));
        List<Movie> users = mongoTemplate.find(query,Movie.class);
        return Optional.of(users);
    }
}
