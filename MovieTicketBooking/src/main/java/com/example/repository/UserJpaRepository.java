package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.MovieTickets;
import com.example.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer>
{
	
	 Optional<User> findByEmailAndPassword(String email, String password);

	    void deleteByEmail(String email);

	    User findByUserId(int userId);

	    List<MovieTickets> getMovieTicketsByUserId(int userId);

}
