package com.example.SuperStore.RequestResponseDTO;;

import com.example.SuperStore.Model.BuyReturn;

import java.util.Date;

public class TxnProductResponseDTO {

    private int productId;
    private int quantity;
    private int custId;
    private int empId;
    private BuyReturn buyReturn;
    private Date purchaseDt;

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

    public Date getPurchaseDt() {
        return purchaseDt;
    }

    public void setPurchaseDt(Date purchaseDt) {
        this.purchaseDt = purchaseDt;
    }
}
