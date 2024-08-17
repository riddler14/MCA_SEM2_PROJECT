package com.example.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Long>{

}
