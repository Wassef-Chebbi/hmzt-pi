package com.example.pi.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryDTO {

    private long categoryId;

    private String nom;

    private String description;

    private String URL;


}
