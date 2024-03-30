package com.example.kadai_002.form;

import java.time.LocalTime;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantEditForm {
	 @NotNull
     private Integer id;    

     @NotBlank(message = "店舗名を入力してください。")
     private String name;

     private MultipartFile imageFile;

     @NotBlank(message = "説明を入力してください。")
     private String description;  

     @NotNull(message = "開店時間を入力してください。")
     private LocalTime openingTime;

     @NotNull(message = "閉店時間を入力してください。")
     private LocalTime closingTime;

     @NotNull(message = "最低価格を入力してください。")
     @Min(value = 1, message = "価格は1円以上に設定してください。")
     private Integer priceRangeMin;  

     @NotNull(message = "最高価格を入力してください。")
     @Min(value = 1, message = "価格は1円以上に設定してください。")
     private Integer priceRangeMax;  

     @NotBlank(message = "郵便番号を入力してください。")
     private String postalCode;

     @NotBlank(message = "住所を入力してください。")
     private String address;

     @NotBlank(message = "電話番号を入力してください。")
     private String phoneNumber;


}