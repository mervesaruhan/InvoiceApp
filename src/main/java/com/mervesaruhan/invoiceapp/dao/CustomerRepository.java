package com.mervesaruhan.invoiceapp.dao;

import com.mervesaruhan.invoiceapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
//    @Query(" select c from Customer c where c.name like %:targetWord% or c.surname like  %:targetWord% " )
//    List<Customer> findAllByTargetWord(@Param("targerword") String targerword);
    List<Customer> findByNameContainingIgnoreCase(String keyword);
}
