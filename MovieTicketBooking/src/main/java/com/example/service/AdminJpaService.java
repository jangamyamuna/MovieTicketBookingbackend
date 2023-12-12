package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Admin;
import com.example.repository.AdminJpaRepository;

@Service
public class AdminJpaService 
{
	 @Autowired
	    private AdminJpaRepository adminJpaRepository;

	    public Admin adminLogin(String email, String password, String role) {
	        try {
	            Optional<Admin> adminOptional = adminJpaRepository.findByEmail(email);
	            if (adminOptional.isPresent()) {
	                Admin admin = adminOptional.get();
	                if (admin.getPassword().equals(password) && admin.getRole().equals(role)) {
	                    return admin;
	                } else {
	                	
	                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
	                }
	            } else {
	                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Admin not found with email: " + email);
	            }
	        } catch (DataAccessException e) {
	            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
	        }
	    }

	    public void addAdmin(Admin admin) {
	        adminJpaRepository.save(admin);
	    }

	    public void deleteAdmin(int id) {
	        try {
	            adminJpaRepository.deleteById(id);
	        } catch (DataAccessException e) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found with id: " + id, e);
	        }
	    }

	

}
