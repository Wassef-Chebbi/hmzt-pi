package com.example.pi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private long categoryId;
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;


    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
//    @JsonBackReference
    @JsonIgnore
    private Set<Ressource> resources =new HashSet<>();
}
