package com.sindhu.service;

import java.util.ArrayList;
import java.util.Collection;

import com.sindhu.model.Product;

public interface ProductService {
	   public abstract void createProduct(Product product);
	   public abstract void updateProduct(long id, Product product);
	   public abstract void deleteProduct(long id);
	   public abstract ArrayList<Product> getProducts();
	   public abstract Product getProduct(long id);
	}