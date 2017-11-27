package com.domain;

public class Client {
    private Integer clientid;

    private String clientname;

    private DataDict dataDict;

    private String bankacctno;

    private String contacttel;

    private String address;

    private Integer zipcode;
    
    private User user;

    @Override
	public String toString() {
		return "Client [clientid=" + clientid + ", clientname=" + clientname + ", dataDict=" + dataDict
				+ ", bankacctno=" + bankacctno + ", contacttel=" + contacttel + ", address=" + address + ", zipcode="
				+ zipcode + ", user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname == null ? null : clientname.trim();
    }

	public DataDict getDataDict() {
		return dataDict;
	}

	public void setDataDict(DataDict dataDict) {
		this.dataDict = dataDict;
	}

	public String getBankacctno() {
        return bankacctno;
    }

    public void setBankacctno(String bankacctno) {
        this.bankacctno = bankacctno == null ? null : bankacctno.trim();
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