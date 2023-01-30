package com.example.SuperStore.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mobile;
    @UpdateTimestamp
    private Date billDt;
    private double billAmount;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Product> boughtItemsList;

    @ManyToOne
    @JoinColumn
    private Employee employee;

    public Customer() {
    }

    public Customer(String name, String mobile, Date billDt, double billAmount) {
        this.name = name;
        this.mobile = mobile;
        this.billDt = billDt;
        this.billAmount = billAmount;
        this.boughtItemsList= new ArrayList<>();
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBillDt() {
        return billDt;
    }

    public void setBillDt(Date billDt) {
        this.billDt = billDt;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public List<Product> getBoughtItemsList() {
        return boughtItemsList;
    }

    public void setBoughtItemsList(List<Product> boughtItemsList) {
        this.boughtItemsList = boughtItemsList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}