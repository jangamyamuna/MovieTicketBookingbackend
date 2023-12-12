package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movieticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieTickets 
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketId", unique = true)
    private int ticketId;

    @ManyToOne 
    @JoinColumn(name = "movieId")
    private Movie movie;
    
    
    @Column(name = "date")
    private String date;
    
    @Column(name = "showTime")
    private String showTime;
    
    @Column(name = "theatre")
    private String theatre;

    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

	
	
	
}
