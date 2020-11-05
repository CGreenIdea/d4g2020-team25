package com.cgi.d4g.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="REGION")
public class Region {
	
    private int rgnId;
    private String rgnName;
    private String rgnCode;

    @Id
    @Column(name = "RGN_ID", nullable = false)
    public int getRgnId() {
        return rgnId;
    }

    public void setRgnId(int rgnId) {
        this.rgnId = rgnId;
    }

    @Basic
    @Column(name = "RGN_NAME", nullable = false, length = 60)
    public String getRgnName() {
        return rgnName;
    }

    public void setRgnName(String rgnName) {
        this.rgnName = rgnName;
    }

    @Basic
    @Column(name = "RGN_CODE", nullable = false, length = 2)
    public String getRgnCode() {
        return rgnCode;
    }

    public void setRgnCode(String rgnCode) {
        this.rgnCode = rgnCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Region region = (Region) o;
        return rgnId == region.rgnId &&
            Objects.equals(rgnName, region.rgnName) &&
            Objects.equals(rgnCode, region.rgnCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rgnId, rgnName, rgnCode);
    }
}
