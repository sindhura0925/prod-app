package com.sindhu.model;

import org.springframework.stereotype.Component;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 

@Component
@Data
@RequiredArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	public long getId() {
		return id;
	}
	public void setId(long id) {
	    this.id = id;
	}
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	   this.name = name;
	}
}