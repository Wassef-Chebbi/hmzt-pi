package com.example.pi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class newRessource {

    private long ressourceId;

    private String nom;

    private String description;

    private String URL;


    public Set<Long> categoriesIds  ;

}
