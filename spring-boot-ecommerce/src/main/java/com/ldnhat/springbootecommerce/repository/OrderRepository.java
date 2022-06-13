package com.ldnhat.springbootecommerce.repository;

import com.ldnhat.springbootecommerce.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Orders, Long> {
    Page<Orders> findByCustomerEntityEmailOrderByDateCreatedDesc(
            @Param("email") String email, Pageable pageable);
}
