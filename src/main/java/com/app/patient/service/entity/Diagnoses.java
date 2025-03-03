package com.app.patient.service.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Diagnoses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String primaryDiagnosis;

    private String secondaryDiagnosis;

    private String thirdDiagnosis;

    @OneToOne(mappedBy = "diagnoses", cascade = CascadeType.ALL)
    private Patient patient;

    public Diagnoses() {
    }

    public String getPrimaryDiagnosis() {
        return primaryDiagnosis;
    }

    public void setPrimaryDiagnosis(String primaryDiagnosis) {
        this.primaryDiagnosis = primaryDiagnosis;
    }

    public String getSecondaryDiagnosis() {
        return secondaryDiagnosis;
    }

    public void setSecondaryDiagnosis(String secondaryDiagnosis) {
        this.secondaryDiagnosis = secondaryDiagnosis;
    }

    public String getThirdDiagnosis() {
        return thirdDiagnosis;
    }

    public void setThirdDiagnosis(String thirdDiagnosis) {
        this.thirdDiagnosis = thirdDiagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Diagnoses that = (Diagnoses) o;
        return Objects.equals(primaryDiagnosis, that.primaryDiagnosis) && Objects.equals(secondaryDiagnosis, that.secondaryDiagnosis) && Objects.equals(thirdDiagnosis, that.thirdDiagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryDiagnosis, secondaryDiagnosis, thirdDiagnosis);
    }
}
