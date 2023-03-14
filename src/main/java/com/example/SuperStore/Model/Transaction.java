package com.example.SuperStore.Model;

import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private int quantity;
    private int custId;
    private int empId;
    @Enumerated(value = EnumType.STRING)
    private BuyReturn buyReturn;         //signifies whether item is bought or returned
    private boolean txnPaid;        //checks if the txn has been cashed or not- for custs buying/returning on diff dates
    @UpdateTimestamp
    private Date purchaseDt;

    public Transaction() {
    }

    public Transaction(int productId, int quantity, int custId, int empId, BuyReturn buyReturn, boolean txnPaid) {
        this.productId = productId;
        this.quantity= quantity;
        this.custId = custId;
        this.empId = empId;
        this.buyReturn = buyReturn;
        this.txnPaid= false;
        this.purchaseDt= new Date();
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public BuyReturn getBuyReturn() {
        return buyReturn;
    }

    public void setBuyReturn(BuyReturn buyReturn) {
        this.buyReturn = buyReturn;
    }

    public boolean isTxnPaid() {
        return txnPaid;
    }

    public void setTxnPaid(boolean txnPaid) {
        this.txnPaid = txnPaid;
    }

    public Date getpurchaseDt() {
        return purchaseDt;
    }

    public void setpurchaseDt(Date purchaseDt) {
        this.purchaseDt = purchaseDt;
    }
}
