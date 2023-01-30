package com.example.SuperStore.Controller;

import com.example.SuperStore.Model.Product;
import com.example.SuperStore.RequestDTO.ProductRequestDTO;
import com.example.SuperStore.Service.ProductService;
import com.example.SuperStore.Service.ServiceImplementation.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/add_product")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        productService.addProduct(productRequestDTO);
        return new ResponseEntity<>("Product added in store!", HttpStatus.CREATED);
    }

    @PutMapping("/stock_product")
    public ResponseEntity<String> stockProduct(@RequestParam("id")int id,@RequestParam("quantity")int quantity)
    {
        productService.stockProduct(id,quantity);
        return new ResponseEntity<>("Product stocked successfully!", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_product_by_id")
    public ResponseEntity<Product> getProductById(@RequestParam("id")int id)
    {
        Product product= productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/get_all_products")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> productList= productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/get_all_products_by_aisle_id")
    public ResponseEntity<List<Product>> getAllProductsByAisleId(@RequestParam("id")int aisleId)
    {
        List<Product> productList= productService.getAllProductsByAisleId(aisleId);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
