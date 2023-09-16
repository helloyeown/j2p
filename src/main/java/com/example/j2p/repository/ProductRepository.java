package com.example.j2p.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.j2p.entity.Product;
import com.example.j2p.repository.search.ProductSearch;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductSearch {
    
    @EntityGraph(attributePaths = "images")
    @Query("select p from Product p where p.delFlag = false and p.pno = :pno")
    Product selectOne(@Param("pno") Long pno);

}
