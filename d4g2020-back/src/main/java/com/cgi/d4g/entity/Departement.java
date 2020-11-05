package com.cgi.d4g.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Departement {
    private int dptId;
    private String dptName;
    private String dptCode;
    private int rgnId;

    @Id
    @Column(name = "DPT_ID", nullable = false)
    public int getDptId() {
        return dptId;
    }

    public void setDptId(int dptId) {
        this.dptId = dptId;
    }

    @Basic
    @Column(name = "DPT_NAME", nullable = true, length = 60)
    public String getDptName() {
        return dptName;
    }

    public void setDptName(String dptName) {
        this.dptName = dptName;
    }

    @Basic
    @Column(name = "DPT_CODE", nullable = true, length = 5)
    public String getDptCode() {
        return dptCode;
    }

    public void setDptCode(String dptCode) {
        this.dptCode = dptCode;
    }

    @Basic
    @Column(name = "RGN_ID", nullable = false)
    public int getRgnId() {
        return rgnId;
    }

    public void setRgnId(int rgnId) {
        this.rgnId = rgnId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Departement that = (Departement) o;
        return dptId == that.dptId &&
            rgnId == that.rgnId &&
            Objects.equals(dptName, that.dptName) &&
            Objects.equals(dptCode, that.dptCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dptId, dptName, dptCode, rgnId);
    }
}
