package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.TicketPurchaseRequestDTO;
import com.example.model.MovieTickets;
import com.example.service.MovieTicketsJpaService;

@RestController
@RequestMapping("/movietickets")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieTicketsController 
{
	 @Autowired
     private MovieTicketsJpaService movieTicketsJpaService;

    @PostMapping("/buy")
    public MovieTickets buyTicketByUserId(@RequestBody TicketPurchaseRequestDTO request) {
        System.out.println(request.getTheatre());
    	return movieTicketsJpaService.buyTicketByUserId(request.getUserId(), request.getMovieId(), request.getShowTime(), request.getTheatre(), request.getDate());
   
    }

    
    @GetMapping("/{userId}")
    public List<MovieTickets> getMovieTicketsByUserId(@PathVariable int userId) {
    	System.out.println("Received userId: " + userId);

        List<MovieTickets> movieTickets = movieTicketsJpaService.getMovieTicketsByUserId(userId);
        
        System.out.println("Response Body: " + movieTickets);
    	
    	return movieTicketsJpaService.getMovieTicketsByUserId(userId);
    
    }
    
    @DeleteMapping("/delete/{ticketId}")
    public void deleteTicket(@PathVariable int ticketId) {
    	
    	movieTicketsJpaService.deleteTicket(ticketId);
    	
    }
    

	
	
	
}
