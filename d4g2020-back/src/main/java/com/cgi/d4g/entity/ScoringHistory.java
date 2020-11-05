package com.cgi.d4g.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "SCORING_HISTORY", schema = "d4g_ifn", catalog = "")
public class ScoringHistory {
	private int sghId;
    private int cddId;
    private int cdsId;
    private LocalDateTime search;

    @Id
    @Column(name = "SGH_ID", nullable = false)
    public int getSghId() {
        return sghId;
    }

    public void setSghId(int sghId) {
        this.sghId = sghId;
    }

    @Basic
    @Column(name = "CDD_ID", nullable = false)
    public int getCddId() {
        return cddId;
    }
    
    
    public void setCddId(int cddId) {
		this.cddId = cddId;
	}
    
    @Basic
    @Column(name = "CDS_ID", nullable = false)
	public int getCdsId() {
		return cdsId;
	}

    public void setCdsId(int cdsId) {
		this.cdsId = cdsId;
	}
    
    @Basic
    @Column(name = "SGH_SEARCH", nullable = false)
	public LocalDateTime getSearch() {
		return search;
	}

	public void setSearch(LocalDateTime search) {
		this.search = search;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cddId;
		result = prime * result + cdsId;
		result = prime * result + ((search == null) ? 0 : search.hashCode());
		result = prime * result + sghId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoringHistory other = (ScoringHistory) obj;
		if (cddId != other.cddId)
			return false;
		if (cdsId != other.cdsId)
			return false;
		if (search == null) {
			if (other.search != null)
				return false;
		} else if (!search.equals(other.search))
			return false;
		if (sghId != other.sghId)
			return false;
		return true;
	}
	
	

}
