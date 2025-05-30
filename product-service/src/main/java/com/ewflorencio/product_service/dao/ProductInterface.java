package com.ewflorencio.product_service.dao;


import com.ewflorencio.product_service.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInterface extends JpaRepository<Products,Integer> {
    @Query(value = "SELECT P.* FROM PRODUCTS AS P WHERE P.ID_BRAND :idBrand", nativeQuery = true)
    List<Products> getByBrand(Integer idBrand);

    @Query(value = "SELECT P.* FROM PRODUCTS AS P WHERE P.ID_CATEGORY :idCategory", nativeQuery = true)
    List<Products> getByCategory(Integer idCategory);

    @Query(value = "SELECT P.* FROM PRODUCTS AS P WHERE P.name = ':name'", nativeQuery = true)
    List<Products> getByName(String name);

}
