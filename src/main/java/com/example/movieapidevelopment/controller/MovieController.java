package com.example.movieapidevelopment.controller;

import com.example.movieapidevelopment.entity.Movie;
import com.example.movieapidevelopment.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return service.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return service.getMovieById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return service.addMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return service.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        service.deleteMovie(id);
    }
}
