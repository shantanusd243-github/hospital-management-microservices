package com.mirna.hospitalmanagementapi.domain.repositories;

import com.mirna.hospitalmanagementapi.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Product entity.
 * Extends JpaRepository to provide CRUD operations and more.
 * 
 * @author 
 * @version 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Custom query to find products by department
   // List<Product> findByDepartmentId(Integer departmentId);

    // Optional: find products by name
    List<Product> findByNameContainingIgnoreCase(String name);
}
