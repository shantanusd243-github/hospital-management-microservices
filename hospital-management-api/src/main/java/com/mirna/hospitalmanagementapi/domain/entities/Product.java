package com.mirna.hospitalmanagementapi.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import com.mirna.hospitalmanagementapi.domain.entities.Department;
import java.math.BigDecimal;

/**
 * Entity class representing a Product or Service that can be sold by doctors to earn money, 
 * associated with a specific department.
 * 
 * @author 
 * @version 1.0
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull(message = "Price cannot be null")
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

    // Default constructor
    public Product() {}

    // Constructor with parameters
    public Product(String name, String description, BigDecimal price, Department department) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.department = department;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
