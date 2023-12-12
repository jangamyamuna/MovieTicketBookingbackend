package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.MovieDTO;
import com.example.model.Movie;
import com.example.service.MovieJpaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/movie")
public class MovieController
{
	 @Autowired
	    private MovieJpaService movieJpaService;

	    @PostMapping("/add")
	    public Movie addMovie(@RequestBody Movie movie) {
	        return movieJpaService.addMovie(movie);
	    }

	    @GetMapping("/get")
	    public List<Movie> getMovies() {
	        return movieJpaService.getMovies();
	    }
	    @GetMapping("/name/{movieName}")
	    public Movie findByMovieName(@PathVariable("movieName") String movieName) {
	        System.out.println("Received movie name: " + movieName);
	        return movieJpaService.getMovieByName(movieName);
	    }


	    
	    @GetMapping("/id/{id}")
	    public Movie getMovieById(@PathVariable int id) {
	        return movieJpaService.getMovieById(id);
	    }

	    @PutMapping("/update/{id}")
	    public Movie updateMovie(@PathVariable int id , @RequestBody MovieDTO movie) {
	    	
	    	return movieJpaService.updateMovie(movie, id);
	   
	    }

	    @DeleteMapping("/delete/{movieId}")
	    public void deleteMovie(@PathVariable int movieId) {
	        movieJpaService.deleteMovie(movieId);
	        
	    }
	
	
}
