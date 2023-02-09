package com.example.SuperStore.RequestResponseDTO;

import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

public class CustomerRequestDTO {

    private String name;
    private String mobile;
    private int employeeId;

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
