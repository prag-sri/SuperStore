package com.example.SuperStore.RequestResponseDTO;

public class ProductRequestDTO {

    private String name;
    private String manufacturer;
    private double price;
    private int quantity;
    private int aisle_id;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name, String manufacturer, double price, int quantity, int aisle_id) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.aisle_id= aisle_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAisle_id() {
        return aisle_id;
    }

    public void setAisle_id(int aisle_id) {
        this.aisle_id = aisle_id;
    }
}
