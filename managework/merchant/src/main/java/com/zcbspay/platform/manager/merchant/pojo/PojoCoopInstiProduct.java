package com.zcbspay.platform.manager.merchant.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TL_COOPINSTI_PRODUCT")
public class PojoCoopInstiProduct implements Serializable {
	private static final long serialVersionUID = 4232244614943943004L;
	
	private long coopInstiId;
	private String prouctId;
	
	@Id
	@Column(name = "COOP_INSTI_ID")
	public long getCoopInstiId() {
		return coopInstiId;
	}
	public void setCoopInstiId(long coopInstiId) {
		this.coopInstiId = coopInstiId;
	}

    @Column(name = "PROUCT_ID")
    public String getProuctId() {
		return prouctId;
	}
	public void setProuctId(String prouctId) {
		this.prouctId = prouctId;
	}
}
