package com.example.kadai_002.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.kadai_002.entity.Review;
import com.example.kadai_002.repository.ReviewRepository;

import jakarta.validation.Valid;


@Controller
public class ReviewController{
    private ReviewRepository reviewRepository;

    @GetMapping("/review")
    public String showReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "review-form";
    }

    @PostMapping("/review")
    public String submitReview(@Valid Review review, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
    	 if (bindingResult.hasErrors()) {
    	        // エラーがある場合の処理
    	        return "review-form";
    	 }

    	        reviewRepository.save(review);
    	        redirectAttributes.addFlashAttribute("successMessage", "レビューが投稿されました！");
    	        return "redirect:/";
    }
}