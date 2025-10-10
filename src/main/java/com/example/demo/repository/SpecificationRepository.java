package com.example.demo.repository;

import com.example.demo.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepository extends JpaRepository<Specification, String> {
}
