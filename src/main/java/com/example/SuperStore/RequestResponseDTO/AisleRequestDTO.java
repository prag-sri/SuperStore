package com.example.SuperStore.RequestResponseDTO;

import com.example.SuperStore.Model.AisleType;

public class AisleRequestDTO {

    private String name;
    private AisleType aisleType;

    public AisleRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AisleType getAisleType() {
        return aisleType;
    }

    public void setAisleType(AisleType aisleType) {
        this.aisleType = aisleType;
    }
}
