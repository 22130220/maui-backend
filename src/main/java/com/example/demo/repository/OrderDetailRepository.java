package com.example.demo.repository;

import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

    @Query("SELECT od FROM OrderDetail od WHERE od.id.orderID = :orderId")
    List<OrderDetail> findByOrderID(@Param("orderId") Integer orderId);
}
