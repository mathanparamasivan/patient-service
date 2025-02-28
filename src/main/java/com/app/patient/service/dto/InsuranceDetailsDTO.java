package com.app.patient.service.dto;

import java.util.Objects;

public class InsuranceDetailsDTO {

    private String insuranceId;
    private String insurerName;
    private String insuranceCompanyName;
    private long totalRequestedAmount;
    private long totalApprovedAmount;
    private long maxEligibleAmount;

    public InsuranceDetailsDTO(){
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
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
        InsuranceDetailsDTO that = (InsuranceDetailsDTO) o;
        return totalRequestedAmount == that.totalRequestedAmount && totalApprovedAmount == that.totalApprovedAmount && maxEligibleAmount == that.maxEligibleAmount && Objects.equals(insuranceId, that.insuranceId) && Objects.equals(insurerName, that.insurerName) && Objects.equals(insuranceCompanyName, that.insuranceCompanyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insuranceId, insurerName, insuranceCompanyName, totalRequestedAmount, totalApprovedAmount, maxEligibleAmount);
    }
}
