package com.example.SuperStore.Service;

import com.example.SuperStore.Model.Product;
import com.example.SuperStore.RequestDTO.ProductRequestDTO;
import com.example.SuperStore.RequestDTO.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    public void addProduct(ProductRequestDTO productRequestDTO);

    public void stockProduct(int id, int quantity);

    public ProductResponseDTO getProductById(int id);

    public List<ProductResponseDTO> getAllProducts();

    public List<ProductResponseDTO> getAllProductsByAisleId(int aisleId);
}
