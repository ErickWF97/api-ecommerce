package com.ewflorencio.product_service.control;


import com.ewflorencio.product_service.model.Products;
import com.ewflorencio.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductControl {

    @Autowired
    ProductService productService;

    @GetMapping("alls")
    public ResponseEntity<List<Products>> getAlls(){
      return productService.getAlls();
    }

    @GetMapping("brand/{idBrand}")
    public ResponseEntity<List<Products>> getProductByBrand(@PathVariable Integer idBrand){
        return productService.getProductByBrand(idBrand);
    }

    @GetMapping("category/{idCategory}")
    public ResponseEntity<List<Products>> getProductByCategory(@PathVariable Integer idCategory){
        return productService.getProductByCategory(idCategory);
    }

    @GetMapping("name/{name}")
    
    public ResponseEntity<List<Products>> getProductByName(@PathVariable String name){
        return productService.getProductByName(name);

    }

    @PostMapping("create")
    public ResponseEntity<String> addProduct(@RequestBody Products products){
        return productService.addProduct(products);
    }

    @PutMapping("change")
    public ResponseEntity<String> changeProduct(@RequestBody Products products){
        return productService.changeProduct(products);
    }

    @DeleteMapping("delete/{idProduct}")
    private ResponseEntity<String> deleteProduct(@PathVariable Integer idProduct){
        return productService.deleteProduct(idProduct);
    }

}
