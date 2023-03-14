package com.example.SuperStore.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Aisle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private AisleType aisleType;

    @OneToMany(mappedBy = "aisle",cascade = CascadeType.ALL)
    private List<Product> productList;

    public Aisle() {
    }

    public Aisle(String name, AisleType aisleType) {
        this.name = name;
        this.aisleType = aisleType;
        this.productList= new ArrayList<>();
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
