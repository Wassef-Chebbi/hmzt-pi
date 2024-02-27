package com.example.pi.model;


import jakarta.persistence.*;
import lombok.*;

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
}
