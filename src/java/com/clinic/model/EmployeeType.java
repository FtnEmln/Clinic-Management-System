package com.clinic.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fatin Amalin
 */
public class EmployeeType implements java.io.Serializable{
    private int EmployeeTypeID;
    private String EmployeeTypeName;

    public EmployeeType() {
    }

    public int getEmployeeTypeID() {
        return EmployeeTypeID;
    }

    public String getEmployeeTypeName() {
        return EmployeeTypeName;
    }

    public void setEmployeeTypeID(int EmployeeTypeID) {
        this.EmployeeTypeID = EmployeeTypeID;
    }

    public void setEmployeeTypeName(String EmployeeTypeName) {
        this.EmployeeTypeName = EmployeeTypeName;
    }
    
}
