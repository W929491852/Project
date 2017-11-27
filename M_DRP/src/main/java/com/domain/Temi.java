package com.domain;

public class Temi {
    private Integer temiid;

    private String teminame;

    private DataDict dataDict;

    private String contactor;

    private String contacttel;

    private String address;

    private Integer zipcode;

    public Integer getTemiid() {
        return temiid;
    }

    public void setTemiid(Integer temiid) {
        this.temiid = temiid;
    }

    public String getTeminame() {
        return teminame;
    }

    public void setTeminame(String teminame) {
        this.teminame = teminame == null ? null : teminame.trim();
    }

    public DataDict getDataDict() {
		return dataDict;
	}

	public void setDataDict(DataDict dataDict) {
		this.dataDict = dataDict;
	}

	public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor == null ? null : contactor.trim();
    }

    public String getContacttel() {
        return contacttel;
    }

    public void setContacttel(String contacttel) {
        this.contacttel = contacttel == null ? null : contacttel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }
}