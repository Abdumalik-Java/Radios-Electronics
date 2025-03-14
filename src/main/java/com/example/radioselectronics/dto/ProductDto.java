package com.example.radioselectronics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private Integer rate;
    private Double price;
    private String description;
    private String model;
    private Integer count;

}