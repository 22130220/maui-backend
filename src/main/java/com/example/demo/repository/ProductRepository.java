package com.example.demo.repository;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("""
            SELECT p FROM Product p JOIN FETCH p.categoryID JOIN FETCH p.subimages WHERE p.productID = :productId
            """)
    Optional<Product> findByIdFetchJoin(@Param("productId") String id);
}
