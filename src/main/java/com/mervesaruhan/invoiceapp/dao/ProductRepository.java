package com.mervesaruhan.invoiceapp.dao;

import com.mervesaruhan.invoiceapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
