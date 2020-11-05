package com.cgi.d4g.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class City {
    private int ctyId;
    private String ctyName;
    private String ctyCodeArm;
    private String ctyPostalCode;
    private Integer dptId;
    private String ctyParentCodeArm;

    @Id
    @Column(name = "CTY_ID", nullable = false)
    public int getCtyId() {
        return ctyId;
    }

    public void setCtyId(int ctyId) {
        this.ctyId = ctyId;
    }

    @Basic
    @Column(name = "CTY_NAME", nullable = false, length = 128)
    public String getCtyName() {
        return ctyName;
    }

    public void setCtyName(String ctyName) {
        this.ctyName = ctyName;
    }

    @Basic
    @Column(name = "CTY_CODE_ARM", nullable = true, length = 5)
    public String getCtyCodeArm() {
        return ctyCodeArm;
    }

    public void setCtyCodeArm(String ctyCodeArm) {
        this.ctyCodeArm = ctyCodeArm;
    }

    @Basic
    @Column(name = "CTY_POSTAL_CODE", nullable = true, length = 6)
    public String getCtyPostalCode() {
        return ctyPostalCode;
    }

    public void setCtyPostalCode(String ctyPostalCode) {
        this.ctyPostalCode = ctyPostalCode;
    }

    @Basic
    @Column(name = "DPT_ID", nullable = true)
    public Integer getDptId() {
        return dptId;
    }

    public void setDptId(Integer dptId) {
        this.dptId = dptId;
    }

    @Basic
    @Column(name = "CTY_PARENT_CODE_ARM", nullable = true, length = 5)
    public String getCtyParentCodeArm() {
        return ctyParentCodeArm;
    }

    public void setCtyParentCodeArm(String ctyParentCodeArm) {
        this.ctyParentCodeArm = ctyParentCodeArm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return ctyId == city.ctyId &&
            Objects.equals(ctyName, city.ctyName) &&
            Objects.equals(ctyCodeArm, city.ctyCodeArm) &&
            Objects.equals(ctyPostalCode, city.ctyPostalCode) &&
            Objects.equals(dptId, city.dptId) &&
            Objects.equals(ctyParentCodeArm, city.ctyParentCodeArm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ctyId, ctyName, ctyCodeArm, ctyPostalCode, dptId, ctyParentCodeArm);
    }
}
