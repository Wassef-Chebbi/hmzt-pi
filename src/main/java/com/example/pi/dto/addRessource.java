package com.example.pi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor

public class addRessource {
    String nom;
    String description;
    public Set<Long> categoriesIds;

}
