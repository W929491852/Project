package com.domain;

import java.util.Date;

public class FlowCardMaster {
    private Integer id;

    private String optType;

    private Client client;

    private String recorderId;

    private Date optDate;

    private String vouSts;

    private String adjusterId;

    private Date adjustDate;

    private String spotterId;

    private Date spotDate;

    private String spotDesc;

    private String confirmerId;

    private Date confDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType == null ? null : optType.trim();
    }


    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getRecorderId() {
        return recorderId;
    }

    public void setRecorderId(String recorderId) {
        this.recorderId = recorderId == null ? null : recorderId.trim();
    }

    public Date getOptDate() {
        return optDate;
    }

    public void setOptDate(Date optDate) {
        this.optDate = optDate;
    }

    public String getVouSts() {
        return vouSts;
    }

    public void setVouSts(String vouSts) {
        this.vouSts = vouSts == null ? null : vouSts.trim();
    }

    public String getAdjusterId() {
        return adjusterId;
    }

    public void setAdjusterId(String adjusterId) {
        this.adjusterId = adjusterId == null ? null : adjusterId.trim();
    }

    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }

    public String getSpotterId() {
        return spotterId;
    }

    public void setSpotterId(String spotterId) {
        this.spotterId = spotterId == null ? null : spotterId.trim();
    }

    public Date getSpotDate() {
        return spotDate;
    }

    public void setSpotDate(Date spotDate) {
        this.spotDate = spotDate;
    }

    public String getSpotDesc() {
        return spotDesc;
    }

    public void setSpotDesc(String spotDesc) {
        this.spotDesc = spotDesc == null ? null : spotDesc.trim();
    }

    public String getConfirmerId() {
        return confirmerId;
    }

    public void setConfirmerId(String confirmerId) {
        this.confirmerId = confirmerId == null ? null : confirmerId.trim();
    }

    public Date getConfDate() {
        return confDate;
    }

    public void setConfDate(Date confDate) {
        this.confDate = confDate;
    }
}