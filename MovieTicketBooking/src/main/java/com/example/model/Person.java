package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person
{
	 @Column(name = "name")
	    private String name;

	    @Column(name = "gender")
	    private String gender;

	    @Column(name = "age")
	    private Integer age; 
	
	
	
}
