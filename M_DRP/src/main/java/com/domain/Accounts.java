package com.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Accounts {
    private Integer id;

    private Integer fiscalyear;

    private Integer fiscalperiod;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date begindate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enddate;

    private String periodsts;
    
    private User user;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFiscalyear() {
        return fiscalyear;
    }

    public void setFiscalyear(Integer fiscalyear) {
        this.fiscalyear = fiscalyear;
    }

    public Integer getFiscalperiod() {
        return fiscalperiod;
    }

    public void setFiscalperiod(Integer fiscalperiod) {
        this.fiscalperiod = fiscalperiod;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getPeriodsts() {
        return periodsts;
    }

    public void setPeriodsts(String periodsts) {
        this.periodsts = periodsts == null ? null : periodsts.trim();
    }
}