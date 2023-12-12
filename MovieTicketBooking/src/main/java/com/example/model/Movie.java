package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie 
{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "movieId")
	    private int movieId;

	    
	    @Column(name = "movieName")
	    private String movieName;

	    @Column(name = "director")
	    private String director;

	    @Column(name = "releaseDate")
	    private String releaseDate;

	    @Column(name = "posterLink")
	    private String posterLink;

	    @Column(name = "trailerLink")
	    private String trailerLink;

	    @Column(name = "genre")
	    private String genre;

	    
	    @JsonIgnore
	    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<MovieTickets> movieTickets;
	    

	
	
	
}
