package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Movie;
import com.example.model.MovieTickets;
import com.example.model.User;

@Repository
public interface MovieTicketsJpaRepository extends JpaRepository<MovieTickets, Integer>
{

	MovieTickets findByUserAndMovieAndShowTime(User user, Movie movie, String showTime);

	static List<MovieTickets> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	List<MovieTickets> findByUser_UserId(int userId);
	
}
