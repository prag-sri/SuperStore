package com.example.SuperStore.Controller;

import com.example.SuperStore.RequestResponseDTO.ProductRequestDTO;
import com.example.SuperStore.RequestResponseDTO.ProductResponseDTO;
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
    public ResponseEntity<ProductResponseDTO> getProductById(@RequestParam("id")int id)
    {
        ProductResponseDTO product= productService.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/get_all_products")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts()
    {
        List<ProductResponseDTO> productList= productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/get_all_products_by_aisle_id")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsByAisleId(@RequestParam("id")int aisleId)
    {
        List<ProductResponseDTO> productList= productService.getAllProductsByAisleId(aisleId);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
