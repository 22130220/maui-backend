package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("""
            SELECT p FROM Product p JOIN FETCH p.categoryID JOIN FETCH p.subimages WHERE p.productID = :productId
            """)
    Optional<Product> findByIdFetchJoin(@Param("productId") String id);

    @Query("""
            SELECT p FROM Product p
            WHERE (:quantitySell IS NULL OR p.quanlitySell < :quantitySell)
            ORDER BY p.quanlitySell DESC
            """)
    List<Product> findNextProductsByQuantitySellNext(@Param("quantitySell") Integer quantitySell, Pageable pageable);
}