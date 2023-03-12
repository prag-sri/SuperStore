package com.example.SuperStore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table
public class Transaction {

    @Id
    private int id;
    private int productId;
    private int custId;
    private int empId;
    private boolean bought;         //signifies whether item is bought or returned
    private int billAmount;
    @UpdateTimestamp
    private Date billDt;

    public Transaction(int productId, int custId, int empId, boolean bought) {
        this.productId = productId;
        this.custId = custId;
        this.empId = empId;
        this.bought = bought;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }

    public Date getBillDt() {
        return billDt;
    }

    public void setBillDt(Date billDt) {
        this.billDt = billDt;
    }
}
