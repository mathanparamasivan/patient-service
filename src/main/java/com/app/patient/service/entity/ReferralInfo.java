package com.app.patient.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class ReferralInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referrerName;
    private String email;
    private long mobileNumber;

    public ReferralInfo() {
    }

    public String getReferrerName() {
        return referrerName;
    }

    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReferralInfo that = (ReferralInfo) o;
        return mobileNumber == that.mobileNumber && Objects.equals(referrerName, that.referrerName) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referrerName, email, mobileNumber);
    }
}
