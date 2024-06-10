package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryInterface extends JpaRepository<Category, Long> {
    // Raw SQL
    // JPQL
    @Query("select e from Category e where e.id =: idCate and e.categoryCode =: codeCate")
    List<Category> search(Long idCate, String codeCate);

    //navive query
    @Query(value = "select * from category", nativeQuery = true)
    List<Category> search2(Long idCate, String codeCate);
}
