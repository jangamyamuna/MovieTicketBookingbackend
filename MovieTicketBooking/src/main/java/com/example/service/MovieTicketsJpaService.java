package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Movie;
import com.example.model.MovieTickets;
import com.example.model.User;
import com.example.repository.MovieJpaRepository;
import com.example.repository.MovieTicketsJpaRepository;
import com.example.repository.UserJpaRepository;

@Service
public class MovieTicketsJpaService 
{
	 @Autowired
	    private MovieTicketsJpaRepository movieTicketsJpaRepository;

	    @Autowired
	    private UserJpaRepository userJpaRepository;


	    @Autowired
	    private MovieJpaRepository movieJpaRepository;

	    
	    @Transactional
	    public MovieTickets buyTicketByUserId(int userId, int movieId, String showTime, String theatre, String date) {
	     
	    	User user = userJpaRepository.findByUserId(userId);
	        if (user == null) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with provided userId: " + userId);
	       
	        }
	        
	        
	        
	        Movie movie = movieJpaRepository.findByMovieId(movieId);
	        if (movie == null) {
	        	
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found with provided movieId: " + movieId);
	       
	        }
	        MovieTickets movieTicket = new MovieTickets();
	        movieTicket.setUser(user);
	        movieTicket.setMovie(movie);
	        movieTicket.setTheatre(theatre);;
	        movieTicket.setShowTime(showTime);
	        movieTicket.setDate(date);
	       
	        return movieTicketsJpaRepository.save(movieTicket);
	        
	    }
	    
	    public List<MovieTickets> getMovieTicketsByUserId(int userId) {
	    	
	      return  movieTicketsJpaRepository.findByUser_UserId(userId);

	    }
	    
	    public void deleteTicket(int ticketId) {
	    	
	    	movieTicketsJpaRepository.deleteById(ticketId);
	    	
	    }
	

}
