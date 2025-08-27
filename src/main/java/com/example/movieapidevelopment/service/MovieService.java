package com.example.movieapidevelopment.service;

import com.example.movieapidevelopment.entity.Movie;
import com.example.movieapidevelopment.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public Movie addMovie(Movie movie) {
        return repository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Movie movie = getMovieById(id);
        movie.setTitle(updatedMovie.getTitle());
        movie.setDirector(updatedMovie.getDirector());
        movie.setReleaseYear(updatedMovie.getReleaseYear());
        movie.setGenre(updatedMovie.getGenre());
        movie.setImdbRating(updatedMovie.getImdbRating());
        return repository.save(movie);
    }

    public void deleteMovie(Long id) {
        repository.deleteById(id);
    }
}
