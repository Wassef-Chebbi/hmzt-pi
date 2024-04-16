package com.example.pi.repository;

import com.example.pi.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource,Long> {

//    @Query(value = "select r from Ressource r, Category c, category_resource cr  where cr.re ")
//
//    List<Ressource> getAllByCategoryId(@Param())
}
