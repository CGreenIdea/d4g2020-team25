package com.cgi.d4g.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IMP_BASE_IC_DIPLOMES_FORMATION", schema = "d4g_ifn", catalog = "")
public class ImpBaseIcDiplomesFormation {
    private int dlfId;
    private String dlfCodeArm;
    private Integer dlfUnscholarOver15;
    private Integer dlfUnscholarNoDiplomaOver15;

    @Id
    @Column(name = "DLF_ID", nullable = false)
    public int getDlfId() {
        return dlfId;
    }

    public void setDlfId(int dlfId) {
        this.dlfId = dlfId;
    }

    @Basic
    @Column(name = "DLF_CODE_ARM", nullable = false, length = 5)
    public String getDlfCodeArm() {
        return dlfCodeArm;
    }

    public void setDlfCodeArm(String dlfCodeArm) {
        this.dlfCodeArm = dlfCodeArm;
    }

    @Basic
    @Column(name = "DLF_UNSCHOLAR_OVER_15", nullable = true, precision = 0)
    public Integer getDlfUnscholarOver15() {
        return dlfUnscholarOver15;
    }

    public void setDlfUnscholarOver15(Integer dlfUnscholarOver15) {
        this.dlfUnscholarOver15 = dlfUnscholarOver15;
    }

    @Basic
    @Column(name = "DLF_UNSCHOLAR_NO_DIPLOMA_OVER_15", nullable = true, precision = 0)
    public Integer getDlfUnscholarNoDiplomaOver15() {
        return dlfUnscholarNoDiplomaOver15;
    }

    public void setDlfUnscholarNoDiplomaOver15(Integer dlfUnscholarNoDiplomaOver15) {
        this.dlfUnscholarNoDiplomaOver15 = dlfUnscholarNoDiplomaOver15;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImpBaseIcDiplomesFormation that = (ImpBaseIcDiplomesFormation) o;
        return dlfId == that.dlfId &&
            Objects.equals(dlfCodeArm, that.dlfCodeArm) &&
            Objects.equals(dlfUnscholarOver15, that.dlfUnscholarOver15) &&
            Objects.equals(dlfUnscholarNoDiplomaOver15, that.dlfUnscholarNoDiplomaOver15);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dlfId, dlfCodeArm, dlfUnscholarOver15, dlfUnscholarNoDiplomaOver15);
    }
}
