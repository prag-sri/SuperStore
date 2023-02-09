package com.example.SuperStore.Service.ServiceImplementation;

import com.example.SuperStore.Model.Aisle;
import com.example.SuperStore.Model.Product;
import com.example.SuperStore.Repository.AisleRepository;
import com.example.SuperStore.Repository.ProductRepository;
import com.example.SuperStore.RequestResponseDTO.ProductRequestDTO;
import com.example.SuperStore.RequestResponseDTO.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        Product newProduct= new Product();
        newProduct.setName(productRequestDTO.getName());
        newProduct.setManufacturer(productRequestDTO.getManufacturer());
        newProduct.setPrice(productRequestDTO.getPrice());
        newProduct.setQuantity(productRequestDTO.getQuantity());
        newProduct.setAisle(aisle);

        List<Product> productList= aisle.getProductList();
        productList.add(newProduct);
        aisle.setProductList(productList);
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
    public ProductResponseDTO getProductById(int id)
    {
        Product product=productRepository.findById(id).get();
        ProductResponseDTO productResponseDTO= new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setManufacturer(product.getManufacturer());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setQuantity(product.getQuantity());
        productResponseDTO.setAisle_id(product.getAisle().getId());

        return productResponseDTO;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts()
    {
        List<Product> productList= productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOList= new ArrayList<>();
        for(Product product: productList)
        {
            ProductResponseDTO productResponseDTO= new ProductResponseDTO();
            productResponseDTO.setId(product.getId());
            productResponseDTO.setName(product.getName());
            productResponseDTO.setManufacturer(product.getManufacturer());
            productResponseDTO.setPrice(product.getPrice());
            productResponseDTO.setQuantity(product.getQuantity());
            productResponseDTO.setAisle_id(product.getAisle().getId());

            productResponseDTOList.add(productResponseDTO);
        }

        return productResponseDTOList;
    }

    @Override
    public List<ProductResponseDTO> getAllProductsByAisleId(int aisleId)
    {
        Aisle aisle= aisleRepository.findById(aisleId).get();
        List<Product> productList= aisle.getProductList();
        List<ProductResponseDTO> productResponseDTOList= new ArrayList<>();
        for(Product product: productList)
        {
            ProductResponseDTO productResponseDTO= new ProductResponseDTO();
            productResponseDTO.setId(product.getId());
            productResponseDTO.setName(product.getName());
            productResponseDTO.setManufacturer(product.getManufacturer());
            productResponseDTO.setPrice(product.getPrice());
            productResponseDTO.setQuantity(product.getQuantity());
            productResponseDTO.setAisle_id(product.getAisle().getId());

            productResponseDTOList.add(productResponseDTO);
        }

        return productResponseDTOList;
    }
}
