package com.example.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}