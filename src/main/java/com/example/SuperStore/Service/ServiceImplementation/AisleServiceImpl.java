package com.example.SuperStore.Service.ServiceImplementation;

import com.example.SuperStore.Model.Aisle;
import com.example.SuperStore.Model.Product;
import com.example.SuperStore.Repository.AisleRepository;
import com.example.SuperStore.RequestResponseDTO.AisleRequestDTO;
import com.example.SuperStore.RequestResponseDTO.AisleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class AisleServiceImpl {

    @Autowired
    AisleRepository aisleRepository;

    public void addAisle(AisleRequestDTO aisleRequestDTO)
    {
        Aisle newAisle= new Aisle();
        newAisle.setName(aisleRequestDTO.getName());
        newAisle.setAisleType(aisleRequestDTO.getAisleType());
        aisleRepository.save(newAisle);
    }

    public AisleResponseDTO getAisleById(int id)
    {
        Aisle aisle= aisleRepository.findById(id).get();
        AisleResponseDTO aisleResponseDTO= new AisleResponseDTO();
        aisleResponseDTO.setId(aisle.getId());
        aisleResponseDTO.setName(aisle.getName());
        aisleResponseDTO.setAisleType(aisle.getAisleType());
        return aisleResponseDTO;
    }

    public List<AisleResponseDTO> getAllAisles()
    {
        List<Aisle> aisleList= aisleRepository.findAll();
        List<AisleResponseDTO> aisleResponseDTOList= new ArrayList<>();
        for(Aisle aisle: aisleList)
        {
            AisleResponseDTO aisleResponseDTO= new AisleResponseDTO();
            aisleResponseDTO.setId(aisle.getId());
            aisleResponseDTO.setName(aisle.getName());
            aisleResponseDTO.setAisleType(aisle.getAisleType());

            aisleResponseDTOList.add(aisleResponseDTO);
        }

        return aisleResponseDTOList;
    }

    public AisleResponseDTO getAisleByProductName(String name)
    {
        List<Aisle> aisleList= aisleRepository.findAll();
        AisleResponseDTO aisleResponseDTO= null;
        for(Aisle aisle: aisleList)
        {
            List<Product> productList= aisle.getProductList();
            for(Product product: productList)
            {
                if(product.getName().equals(name)) {
                    aisleResponseDTO= new AisleResponseDTO();
                    aisleResponseDTO.setId(aisle.getId());
                    aisleResponseDTO.setName(aisle.getName());
                    aisleResponseDTO.setAisleType(aisle.getAisleType());
                    return aisleResponseDTO;
                }
            }
        }
        return aisleResponseDTO;
    }

    public AisleResponseDTO getAisleByProductId(@RequestParam("id") int id)
    {
        List<Aisle> aisleList= aisleRepository.findAll();
        AisleResponseDTO aisleResponseDTO= null;
        for(Aisle aisle: aisleList)
        {
            List<Product> productList= aisle.getProductList();
            for(Product product: productList)
            {
                if(product.getId()==id)
                {
                    aisleResponseDTO= new AisleResponseDTO();
                    aisleResponseDTO.setId(aisle.getId());
                    aisleResponseDTO.setName(aisle.getName());
                    aisleResponseDTO.setAisleType(aisle.getAisleType());
                    return aisleResponseDTO;
                }
            }
        }
        return aisleResponseDTO;
    }

}
