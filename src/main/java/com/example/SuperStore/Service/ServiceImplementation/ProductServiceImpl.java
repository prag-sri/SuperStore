package com.example.SuperStore.Service.ServiceImplementation;

import com.example.SuperStore.Model.Aisle;
import com.example.SuperStore.Model.Product;
import com.example.SuperStore.Repository.AisleRepository;
import com.example.SuperStore.Repository.ProductRepository;
import com.example.SuperStore.RequestDTO.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductServiceImpl implements com.example.SuperStore.Service.ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AisleRepository aisleRepository;

    @Override
    public void addProduct(ProductRequestDTO productRequestDTO) {
        Aisle aisle= aisleRepository.findById(productRequestDTO.getAisle_id()).get();
        Product newProduct= Product.builder()
                .name(productRequestDTO.getName())
                .manufacturer(productRequestDTO.getManufacturer())
                .price(productRequestDTO.getPrice())
                .quantity(productRequestDTO.getQuantity())
                .aisle(aisle).build();
        productRepository.save(newProduct);
    }

    @Override
    public void stockProduct(int id, int quantity)
    {
        Product product= productRepository.findById(id).get();
        int previousQuantity= product.getQuantity();
        product.setQuantity(previousQuantity + quantity);
        productRepository.save(product);
    }

    @Override
    public Product getProductById(int id)
    {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts()
    {
        List<Product> productList= productRepository.findAll();
        return productList;
    }

    @Override
    public List<Product> getAllProductsByAisleId(int aisleId)
    {
        Aisle aisle= aisleRepository.findById(aisleId).get();
        return aisle.getProductList();
    }
}
