package com.example.pi.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ressource")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ressource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ressourceId")
    private long ressourceId;
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "category_resource",
            joinColumns = @JoinColumn(name = "resource_id", referencedColumnName = "ressourceId"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "categoryId"))
    private List<Category> categories;


}
