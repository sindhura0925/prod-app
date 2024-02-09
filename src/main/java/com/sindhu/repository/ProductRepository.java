package com.sindhu.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.sindhu.model.Product; 

@Repository 
public interface ProductRepository extends JpaRepository<Product, Long>{ 
    //ArrayList<Product> findAllEmployee(); 
}
