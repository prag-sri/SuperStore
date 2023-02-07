package com.example.SuperStore.Service;

import com.example.SuperStore.Model.Aisle;
import com.example.SuperStore.RequestDTO.AisleRequestDTO;
import com.example.SuperStore.RequestDTO.AisleResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AisleService {

    public void addAisle(AisleRequestDTO aisleRequestDTO);

    public AisleResponseDTO getAisleById(int id);

    public List<Aisle> getAllAisles();

    public Aisle getAisleByProductName(String name);

    public Aisle getAisleByProductId(@RequestParam("id") int id);
}
