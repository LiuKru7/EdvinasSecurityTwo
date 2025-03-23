package com.liu.EdvinasSecurityTwo.carParts.repository;

import com.liu.EdvinasSecurityTwo.carParts.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
