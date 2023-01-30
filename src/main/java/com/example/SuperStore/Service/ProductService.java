package com.example.SuperStore.Service;

import com.example.SuperStore.Model.Product;
import com.example.SuperStore.RequestDTO.ProductRequestDTO;

import java.util.List;

public interface ProductService {

    public void addProduct(ProductRequestDTO productRequestDTO);

    public void stockProduct(int id, int quantity);

    public Product getProductById(int id);

    public List<Product> getAllProducts();

    public List<Product> getAllProductsByAisleId(int aisleId);
}
