package com.example.kadai_002.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.kadai_002.entity.Restaurant;
import com.example.kadai_002.repository.RestaurantRepository;

@Controller
public class EatingController{
	private final RestaurantRepository restaurantRepository;        
    
    public EatingController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;            
    }    	
     @GetMapping("/")
     public String index(Model model) {
    	 List<Restaurant> newRestaurants = restaurantRepository.findTop10ByOrderByCreatedAtDesc();
         model.addAttribute("newRestaurants",newRestaurants);
         return "index";
     }
}
