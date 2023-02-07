package com.example.SuperStore.RequestDTO;

import com.example.SuperStore.Model.AisleType;

public class AisleResponseDTO {
    private int id;
    private String name;
    private AisleType aisleType;

    public AisleResponseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
