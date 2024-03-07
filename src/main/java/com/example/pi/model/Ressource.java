package com.example.pi.model;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.InputStream;

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

    @Column(name = "type")
    private String fileURL ;
    //= "file/ressource/"+ String.valueOf(ressourceId)


















    //@JsonManagedReference
    @ManyToMany
    @JoinTable(name = "category_resource",
            joinColumns = @JoinColumn(name = "resource_id", referencedColumnName = "ressourceId"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "categoryId"))
    //@JsonIgnore
    private Set<Category> categories = new HashSet<>();


}
