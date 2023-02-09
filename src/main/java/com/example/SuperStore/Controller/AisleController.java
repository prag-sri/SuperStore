package com.example.SuperStore.Controller;

import com.example.SuperStore.RequestResponseDTO.AisleRequestDTO;
import com.example.SuperStore.RequestResponseDTO.AisleResponseDTO;
import com.example.SuperStore.Service.ServiceImplementation.AisleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aisle")
public class AisleController {

    @Autowired
    AisleServiceImpl aisleService;

    @PostMapping("/add_aisle")
    public ResponseEntity<String> addAisle(@RequestBody AisleRequestDTO aisleRequestDTO)
    {
        aisleService.addAisle(aisleRequestDTO);
        return new ResponseEntity<>("Aisle added successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/get_aisle_by_id")
    public ResponseEntity<AisleResponseDTO> getAisleById(@RequestParam("id") int id)
    {
        AisleResponseDTO aisle= aisleService.getAisleById(id);
        return new ResponseEntity<>(aisle,HttpStatus.OK);
    }

    @GetMapping("/get_all_aisles")
    public ResponseEntity<List<AisleResponseDTO>> getAllAisles()
    {
        List<AisleResponseDTO> aisleList= aisleService.getAllAisles();
        return new ResponseEntity<>(aisleList,HttpStatus.OK);
    }

    @GetMapping("/get_aisle_by_product_name")
    public ResponseEntity<AisleResponseDTO> getAisleByProductName(@RequestParam("name") String name)
    {
        AisleResponseDTO aisle= aisleService.getAisleByProductName(name);
        return new ResponseEntity<>(aisle,HttpStatus.OK);
    }

    @GetMapping("/get_aisle_by_product_id")
    public ResponseEntity<AisleResponseDTO> getAisleByProductId(@RequestParam("id") int id)
    {
        AisleResponseDTO aisle= aisleService.getAisleByProductId(id);
        return new ResponseEntity<>(aisle,HttpStatus.OK);
    }
}
