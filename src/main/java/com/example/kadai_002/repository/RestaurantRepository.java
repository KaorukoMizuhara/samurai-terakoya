package com.example.kadai_002.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kadai_002.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

//店舗名と住所で検索する（新着順）
public Page<Restaurant> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword, Pageable pageable); 
//すべてのデータを取得する（新着順）
public Page<Restaurant> findAllByOrderByCreatedAtDesc(Pageable pageable);
//評価を取得する（高評価順）
//public Page<Restaurant> findByReviewByCreatedAtDesc(Pageable pageable);

public List<Restaurant> findTop10ByOrderByCreatedAtDesc();
public Page<Restaurant> findByCategoryLike(String string, Pageable pageable);

}