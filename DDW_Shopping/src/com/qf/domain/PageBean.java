package com.qf.domain;

import java.util.List;

public class PageBean<T> {
	private int currPage;
	private int count;
	private int totalPage;
	private List<T> list;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public PageBean(int currPage, int count, int totalPage, List<T> list) {
		super();
		this.currPage = currPage;
		this.count = count;
		this.totalPage = totalPage;
		this.list = list;
	}
	public PageBean() {
		super();
	}
	
}
