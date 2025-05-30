package com.ewflorencio.product_service.service;


import com.ewflorencio.product_service.dao.ColorInterface;
import com.ewflorencio.product_service.dao.ProductInterface;
import com.ewflorencio.product_service.dao.SizeInterface;
import com.ewflorencio.product_service.model.Color;
import com.ewflorencio.product_service.model.Products;
import com.ewflorencio.product_service.model.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    ProductInterface productInterface;

    @Autowired
    SizeInterface sizeInterface;

    @Autowired
    ColorInterface colorInterface;


    public ResponseEntity<List<Products>> getAlls(){

        return new ResponseEntity<>(productInterface.findAll(), HttpStatus.OK);

    }

    public ResponseEntity<List<Products>> getProductByBrand(Integer idBrand){

        List<Products> productsList = productInterface.getByBrand(idBrand);

        return new ResponseEntity<>(productsList, HttpStatus.OK);

    }

    public ResponseEntity<List<Products>> getProductByCategory(Integer idCategory){

        List<Products> productsList = productInterface.getByCategory(idCategory);

        return new ResponseEntity<>(productsList, HttpStatus.OK);

    }

    public ResponseEntity<List<Products>> getProductByName(String name){

        List<Products> productsList = productInterface.getByName(name);

        return new ResponseEntity<>(productsList, HttpStatus.OK);

    }

    public ResponseEntity<String> addProduct(Products products){

        List<Size> newSizeList = sizeInterface.saveAll(products.getSizes());
        List<Color> newColorList = colorInterface.saveAll(products.getColors());

        products.setSizes(newSizeList);
        products.setColors(newColorList);

        productInterface.save(products);

        return new ResponseEntity<>("Registered successfully!!!", HttpStatus.CREATED);

    }

    public ResponseEntity<String> changeProduct(Products products){

        List<Size> newSizeList = sizeInterface.saveAll(products.getSizes());
        List<Color> newColorList = colorInterface.saveAll(products.getColors());

        products.setSizes(newSizeList);
        products.setColors(newColorList);

        productInterface.save(products);

        return new ResponseEntity<>("Changed successfully!!!", HttpStatus.OK);

    }


    public ResponseEntity<String> deleteProduct(int idProduct){

        productInterface.deleteById(idProduct);

        return new ResponseEntity<>("Deleted successfully!!!",HttpStatus.OK);

    }

}
