package com.sindhu.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sindhu.exception.ProductNotfoundException;
import com.sindhu.model.Product;
import com.sindhu.service.ProductService;


@RestController
@CrossOrigin("http://localhost:4200")
public class ProductServiceController {
   @Autowired
   ProductService productService;

   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProducts() {
      return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
   }
   
   @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
   public ResponseEntity<Object> getProduct(@PathVariable("id") long id) {
      return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
   }
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> 
      updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
      
      productService.updateProduct(id, product);
      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
   }
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") long id) {
      productService.deleteProduct(id);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
      productService.createProduct(product);
      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
   }
}



/*
 * @RestController public class ProductServiceController { public static
 * Map<String, Product> productRepo = new HashMap<>(); static { Product honey =
 * new Product(); honey.setId("1"); honey.setName("Honey");
 * productRepo.put(honey.getId(), honey);
 * 
 * Product almond = new Product(); almond.setId("2"); almond.setName("Almond");
 * productRepo.put(almond.getId(), almond); }
 * 
 * @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
 * public ResponseEntity<Object> delete(@PathVariable("id") String id) {
 * productRepo.remove(id); return new
 * ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK); }
 * 
 * @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT) public
 * ResponseEntity<Object> updateProduct(@PathVariable("id") String
 * id, @RequestBody Product product) { if(!productRepo.containsKey(id))throw new
 * ProductNotfoundException(); productRepo.remove(id); product.setId(id);
 * productRepo.put(id, product); return new
 * ResponseEntity<>("Product is updated successfully", HttpStatus.OK); }
 * 
 * @RequestMapping(value = "/products", method = RequestMethod.POST) public
 * ResponseEntity<Object> createProduct(@RequestBody Product product) {
 * productRepo.put(product.getId(), product); return new
 * ResponseEntity<>("Product is created successfully", HttpStatus.CREATED); }
 * 
 * @RequestMapping(value = "/products") public ResponseEntity<Object>
 * getProduct() { return new ResponseEntity<>(productRepo.values(),
 * HttpStatus.OK); }
 * 
 * @RequestMapping(value = "/product") public ResponseEntity<Object>
 * getMySingleProduct(@RequestParam(value = "prodId", required = false,
 * defaultValue = "1") String id) { return new
 * ResponseEntity<>(productRepo.get(id), HttpStatus.OK); }
 * 
 * @RequestMapping(value = "/product/{id}") public ResponseEntity<Object>
 * getSingleProduct(@PathVariable String id) { return new
 * ResponseEntity<>(productRepo.get(id), HttpStatus.OK); }
 * 
 * @RequestMapping(value = "/") public String hello() { return "Hello World"; }
 * }
 */