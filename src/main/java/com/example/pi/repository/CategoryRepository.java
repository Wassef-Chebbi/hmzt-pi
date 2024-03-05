package com.example.pi.repository;


import com.example.pi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Transactional
    @Modifying
    @Query(value = "delete  from  category_resource cr where cr.category_id = ?",nativeQuery = true)
    void delete(@Param("categoryId") long categoryId);


}
