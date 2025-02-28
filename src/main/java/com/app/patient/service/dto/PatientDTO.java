package com.app.patient.service.dto;

import java.time.LocalDate;

public class PatientDTO {

    private String medicalRecordNumber;
    private LocalDate startOfCareDate;
    private String status;
    private String firstName;
    private String lastName;
    private String sex;
    private LocalDate birthDate;
    private String maritalStatus;
    private String address;
    private String city;
    private String state;
    private String county;
    private String zipCode;
    private String email;
    private long mobile;
    private DiagnosesDTO diagnoses;
    private ReferralInfoDTO referralInfo;
    private InsuranceDetailsDTO insuranceDetails;
    private PhysicianDTO primaryPhysician;

    public PatientDTO() {
    }

    // Getters and Setters
    public String getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(String medicalRecordNumber) {
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public LocalDate getStartOfCareDate() {
        return startOfCareDate;
    }

    public void setStartOfCareDate(LocalDate startOfCareDate) {
        this.startOfCareDate = startOfCareDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public DiagnosesDTO getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(DiagnosesDTO diagnoses) {
        this.diagnoses = diagnoses;
    }

    public ReferralInfoDTO getReferralInfo() {
        return referralInfo;
    }

    public void setReferralInfo(ReferralInfoDTO referralInfo) {
        this.referralInfo = referralInfo;
    }

    public InsuranceDetailsDTO getInsuranceDetails() {
        return insuranceDetails;
    }

    public void setInsuranceDetails(InsuranceDetailsDTO insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    public PhysicianDTO getPrimaryPhysician() {
        return primaryPhysician;
    }

    public void setPrimaryPhysician(PhysicianDTO primaryPhysician) {
        this.primaryPhysician = primaryPhysician;
    }
}
