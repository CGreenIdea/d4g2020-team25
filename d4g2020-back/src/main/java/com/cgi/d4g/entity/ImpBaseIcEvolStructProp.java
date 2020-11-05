package com.cgi.d4g.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IMP_BASE_IC_EVOL_STRUCT_PROP", schema = "d4g_ifn", catalog = "")
public class ImpBaseIcEvolStructProp {
    private long espId;
    private String espCodeArm;
    private Integer espTotalPop;
    private Integer espPopAge014;
    private Integer espPopAge1529;
    private Integer espPopAgeOver65;
    private Integer espPopNoJobOver15;

    @Id
    @Column(name = "ESP_ID", nullable = false)
    public long getEspId() {
        return espId;
    }

    public void setEspId(long espId) {
        this.espId = espId;
    }

    @Basic
    @Column(name = "ESP_CODE_ARM", nullable = false, length = 5)
    public String getEspCodeArm() {
        return espCodeArm;
    }

    public void setEspCodeArm(String espCodeArm) {
        this.espCodeArm = espCodeArm;
    }

    @Basic
    @Column(name = "ESP_TOTAL_POP", nullable = true, precision = 0)
    public Integer getEspTotalPop() {
        return espTotalPop;
    }

    public void setEspTotalPop(Integer espTotalPop) {
        this.espTotalPop = espTotalPop;
    }

    @Basic
    @Column(name = "ESP_POP_AGE_0_14", nullable = true, precision = 0)
    public Integer getEspPopAge014() {
        return espPopAge014;
    }

    public void setEspPopAge014(Integer espPopAge014) {
        this.espPopAge014 = espPopAge014;
    }

    @Basic
    @Column(name = "ESP_POP_AGE_15_29", nullable = true, precision = 0)
    public Integer getEspPopAge1529() {
        return espPopAge1529;
    }

    public void setEspPopAge1529(Integer espPopAge1529) {
        this.espPopAge1529 = espPopAge1529;
    }

    @Basic
    @Column(name = "ESP_POP_AGE_OVER_65", nullable = true, precision = 0)
    public Integer getEspPopAgeOver65() {
        return espPopAgeOver65;
    }

    public void setEspPopAgeOver65(Integer espPopAgeOver65) {
        this.espPopAgeOver65 = espPopAgeOver65;
    }

    @Basic
    @Column(name = "ESP_POP_NO_JOB_OVER_15", nullable = true, precision = 0)
    public Integer getEspPopNoJobOver15() {
        return espPopNoJobOver15;
    }

    public void setEspPopNoJobOver15(Integer espPopNoJobOver15) {
        this.espPopNoJobOver15 = espPopNoJobOver15;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImpBaseIcEvolStructProp that = (ImpBaseIcEvolStructProp) o;
        return espId == that.espId &&
            Objects.equals(espCodeArm, that.espCodeArm) &&
            Objects.equals(espTotalPop, that.espTotalPop) &&
            Objects.equals(espPopAge014, that.espPopAge014) &&
            Objects.equals(espPopAge1529, that.espPopAge1529) &&
            Objects.equals(espPopAgeOver65, that.espPopAgeOver65) &&
            Objects.equals(espPopNoJobOver15, that.espPopNoJobOver15);
    }

    @Override
    public int hashCode() {
        return Objects.hash(espId, espCodeArm, espTotalPop, espPopAge014, espPopAge1529, espPopAgeOver65, espPopNoJobOver15);
    }
}
