package com.app.patient.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class InsuranceDetails {

    @Id
    private String id;
    private String insurerName;
    private String insuranceCompanyName;
    private long totalRequestedAmount;
    private long totalApprovedAmount;
    private long maxEligibleAmount;

    public InsuranceDetails(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public long getTotalRequestedAmount() {
        return totalRequestedAmount;
    }

    public void setTotalRequestedAmount(long totalRequestedAmount) {
        this.totalRequestedAmount = totalRequestedAmount;
    }

    public long getTotalApprovedAmount() {
        return totalApprovedAmount;
    }

    public void setTotalApprovedAmount(long totalApprovedAmount) {
        this.totalApprovedAmount = totalApprovedAmount;
    }

    public long getMaxEligibleAmount() {
        return maxEligibleAmount;
    }

    public void setMaxEligibleAmount(long maxEligibleAmount) {
        this.maxEligibleAmount = maxEligibleAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceDetails that = (InsuranceDetails) o;
        return totalRequestedAmount == that.totalRequestedAmount && totalApprovedAmount == that.totalApprovedAmount && maxEligibleAmount == that.maxEligibleAmount && Objects.equals(id, that.id) && Objects.equals(insurerName, that.insurerName) && Objects.equals(insuranceCompanyName, that.insuranceCompanyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, insurerName, insuranceCompanyName, totalRequestedAmount, totalApprovedAmount, maxEligibleAmount);
    }
}
