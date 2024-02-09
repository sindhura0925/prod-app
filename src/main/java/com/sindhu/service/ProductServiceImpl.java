package com.sindhu.service;

import java.util.ArrayList;

import java.util.Iterator; 
import java.util.Optional; 
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindhu.exception.ProductAlreadyExistsException;
import com.sindhu.exception.ProductNotfoundException;
import com.sindhu.model.Product;
import com.sindhu.repository.ProductRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepo;
   //public static Map<String, Product> productRepo = new HashMap<>();
	/*
	 * static { Product honey = new Product(); honey.setId("1");
	 * honey.setName("Honey"); productRepo.put(honey.getId(), honey);
	 * 
	 * Product almond = new Product(); almond.setId("2"); almond.setName("Almond");
	 * productRepo.put(almond.getId(), almond); }
	 */
   @Override
   public void createProduct(Product product) {
	  Product existingProduct= productRepo.findById(product.getId()).orElse(null);
	  
	  if (existingProduct == null) {
		  productRepo.save(product);
          //return "Product added successfully";
      }
      else
          throw new ProductAlreadyExistsException(
              "Product already exists!!");
      
   }
   @Override
   public void updateProduct(long id, Product product) {
	  Product existingProduct= productRepo.findById(id).orElse(null);
	  if (existingProduct == null)
          throw new ProductNotfoundException(
              "No Such Product exists!!");
      else {
    	  existingProduct.setId(id);
    	  existingProduct.setName(product.getName());
          productRepo.save(existingProduct);
      }
	  
   }
 
   @Override
   public ArrayList<Product> getProducts() {
      return (ArrayList<Product>)productRepo.findAll();
   }
	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		Product existingProduct= productRepo.findById(id).orElse(null);
		  if (existingProduct == null)
	          throw new ProductNotfoundException(
	              "No Such Product exists!!");
		productRepo.deleteById(id);
	}
	@Override
	public Product getProduct(long id) {
		Optional<Product> opt = productRepo.findById(id); 
        if (opt.isPresent()) 
            return opt.get(); 
        else
            throw new ProductNotfoundException("NO CUSTOMER PRESENT WITH ID = " + id);
		
	}
}