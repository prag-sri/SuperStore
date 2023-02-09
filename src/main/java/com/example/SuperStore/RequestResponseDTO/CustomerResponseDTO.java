package com.example.SuperStore.RequestResponseDTO;

import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

public class CustomerResponseDTO {

    private int id;
    private String name;
    private String mobile;
    @UpdateTimestamp
    private Date billDt;
    private double billAmount;
    private EmployeeResponseDTO employeeResponseDTO;

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

    public EmployeeResponseDTO getEmployeeResponseDTO() {
        return employeeResponseDTO;
    }

    public void setEmployeeResponseDTO(EmployeeResponseDTO employeeResponseDTO) {
        this.employeeResponseDTO = employeeResponseDTO;
    }
}
