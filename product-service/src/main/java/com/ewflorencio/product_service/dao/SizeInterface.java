package com.ewflorencio.product_service.dao;

import com.ewflorencio.product_service.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeInterface  extends JpaRepository<Size,Integer> {
}
