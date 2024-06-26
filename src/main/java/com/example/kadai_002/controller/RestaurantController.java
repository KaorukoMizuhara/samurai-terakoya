package com.example.kadai_002.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kadai_002.entity.Restaurant;
import com.example.kadai_002.form.ReservationInputForm;
import com.example.kadai_002.repository.RestaurantRepository;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	private final RestaurantRepository restaurantRepository;        

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;            
    } 

    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword,
                        @RequestParam(name = "category", required = false) String category,
                        @RequestParam(name = "order", required = false) String order,
                        @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
                        Model model) 
    {
        Page<Restaurant> restaurantPage;

        if (keyword != null && !keyword.isEmpty()) {
            restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrderByCreatedAtDesc("%" + keyword + "%", "%" + keyword + "%", pageable);
        }  else if (category != null) {
        	restaurantPage = restaurantRepository.findByCategoryLike("%" + category + "%", pageable);
        } else {
        	restaurantPage = restaurantRepository.findAll(pageable);
        }                

        model.addAttribute("restaurantPage", restaurantPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("category", category);                              

        return "restaurants/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable(name = "id") Integer id, Model model) {
        Restaurant restaurant = restaurantRepository.getReferenceById(id);

        model.addAttribute("restaurant", restaurant);  
        model.addAttribute("reservationInputForm", new ReservationInputForm());

        return "restaurants/show";
    }    

}
