package com.ewflorencio.product_service.dao;

import com.ewflorencio.product_service.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorInterface extends JpaRepository<Color,Integer> {
}
