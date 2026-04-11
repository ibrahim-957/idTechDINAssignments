package com.ibrahim.simpleshop.dao.repository;

import com.ibrahim.simpleshop.dao.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT DISTINCT o FROM Order o " +
            "JOIN FETCH o.user u " +
            "JOIN FETCH o.orderItems oi " +
            "JOIN FETCH oi.product " +
            "WHERE u.email = : email",
    countQuery = "SELECT COUNT(DISTINCT o) FROM Order o " +
            "JOIN o.user u " +
            "WHERE u.email =: email")
    Page<Order> findAllByUserEmailWithItems(String email, Pageable pageable);

    Page<Order> findAllByUserEmail(String email, Pageable pageable);
}
