package com.example.radioselectronics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    private String name;
    private String description;
    private UUID photoId;
    private UUID commentId;

}