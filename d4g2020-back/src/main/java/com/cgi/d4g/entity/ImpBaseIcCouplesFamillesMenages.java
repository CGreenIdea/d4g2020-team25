package com.cgi.d4g.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IMP_BASE_IC_COUPLES_FAMILLES_MENAGES", schema = "d4g_ifn", catalog = "")
public class ImpBaseIcCouplesFamillesMenages {
    private long cfmId;
    private String cfmCodeArm;
    private Integer cfmSingle;
    private Integer cfmSingleParent;;
    private Integer cfmHousehold;

    @Id
    @Column(name = "CFM_ID", nullable = false)
    public long getCfmId() {
        return cfmId;
    }

    public void setCfmId(long cfmId) {
        this.cfmId = cfmId;
    }

    @Basic
    @Column(name = "CFM_CODE_ARM", nullable = false, length = 5)
    public String getCfmCodeArm() {
        return cfmCodeArm;
    }

    public void setCfmCodeArm(String cfmCodeArm) {
        this.cfmCodeArm = cfmCodeArm;
    }

    @Basic
    @Column(name = "CFM_SINGLE", nullable = true, precision = 0)
    public Integer getCfmSingle() {
        return cfmSingle;
    }

    public void setCfmSingle(Integer cfmSingle) {
        this.cfmSingle = cfmSingle;
    }

    @Basic
    @Column(name = "CFM_SINGLE_PARENT", nullable = true, precision = 0)
    public Integer getCfmSingleParent() {
        return cfmSingleParent;
    }

    public void setCfmSingleParent(Integer cfmSingleParent) {
        this.cfmSingleParent = cfmSingleParent;
    }
    
    @Basic
    @Column(name = "CFM_HOUSEHOLD", nullable = true, precision = 0)
    public Integer getCfmHousehold() {
        return cfmHousehold;
    }

    public void setCfmHousehold(Integer cfmHousehold) {
        this.cfmHousehold = cfmHousehold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImpBaseIcCouplesFamillesMenages that = (ImpBaseIcCouplesFamillesMenages) o;
        return cfmId == that.cfmId &&
            Objects.equals(cfmCodeArm, that.cfmCodeArm) &&
            Objects.equals(cfmSingle, that.cfmSingle) &&
            Objects.equals(cfmSingleParent, that.cfmSingleParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cfmId, cfmCodeArm, cfmSingle, cfmSingleParent);
    }
}
