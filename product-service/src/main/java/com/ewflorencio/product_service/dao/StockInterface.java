package com.ewflorencio.product_service.dao;

import com.ewflorencio.product_service.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockInterface extends JpaRepository<Stock, Integer> {
}
