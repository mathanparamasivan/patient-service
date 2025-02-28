package com.app.patient.service.dto;

import java.util.Objects;

public class DiagnosesDTO {

    private String primaryDiagnosis;

    private String secondaryDiagnosis;

    private String thirdDiagnosis;

    public DiagnosesDTO() {
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
        DiagnosesDTO that = (DiagnosesDTO) o;
        return Objects.equals(primaryDiagnosis, that.primaryDiagnosis) && Objects.equals(secondaryDiagnosis, that.secondaryDiagnosis) && Objects.equals(thirdDiagnosis, that.thirdDiagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryDiagnosis, secondaryDiagnosis, thirdDiagnosis);
    }
}
