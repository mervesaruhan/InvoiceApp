package com.mervesaruhan.invoiceapp.dao;

import com.mervesaruhan.invoiceapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
