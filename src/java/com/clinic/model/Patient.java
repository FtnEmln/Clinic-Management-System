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
public class Patient implements java.io.Serializable{
    private String PatientICNo;
    private String PatientFirstName;
    private String PatientLastName;   
    private String PatientAddress;
    private String PatientPhone;
    private String PatientEmergencyPhone;

    public Patient() {
    }

    public String getPatientICNo() {
        return PatientICNo;
    }

    public String getPatientFirstName() {
        return PatientFirstName;
    }

    public String getPatientLastName() {
        return PatientLastName;
    }

    public String getPatientAddress() {
        return PatientAddress;
    }

    public String getPatientPhone() {
        return PatientPhone;
    }

    public String getPatientEmergencyPhone() {
        return PatientEmergencyPhone;
    }

    public void setPatientICNo(String PatientICNo) {
        this.PatientICNo = PatientICNo;
    }

    public void setPatientFirstName(String PatientFirstName) {
        this.PatientFirstName = PatientFirstName;
    }

    public void setPatientLastName(String PatientLastName) {
        this.PatientLastName = PatientLastName;
    }

    public void setPatientAddress(String PatientAddress) {
        this.PatientAddress = PatientAddress;
    }

    public void setPatientPhone(String PatientPhone) {
        this.PatientPhone = PatientPhone;
    }

    public void setPatientEmergencyPhone(String PatientEmergencyPhone) {
        this.PatientEmergencyPhone = PatientEmergencyPhone;
    }
    
}
