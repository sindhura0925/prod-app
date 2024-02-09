package com.sindhu;

import org.springframework.boot.ApplicationRunner;






 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ApplicationArguments;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sindhu.service.ProductServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j; 


@SpringBootApplication
public class SampleProdCrudApplication implements ApplicationRunner {
	//private static final Logger LOGGER = 
			//LoggerFactory.getLogger(SampleProdCrudApplication.class);
	
	public static void main(String[] args) {
		//LOGGER.info("This is an INFO level log message!");
	    //LOGGER.error("This is an ERROR level log message!");
	    SpringApplication.run(SampleProdCrudApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
	      System.out.println("Hello World from Application Runner");
	      //System.out.println(ProductServiceImpl.productRepo);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

}
