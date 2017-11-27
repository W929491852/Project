package com.domain;

public class Inventory {
    private Integer id;

    private Client client;

    private Item item;

    private Integer initqty;

    private Integer inqty;

    private Integer outqty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getInitqty() {
		return initqty;
	}

	public void setInitqty(Integer initqty) {
		this.initqty = initqty;
	}

	public Integer getInqty() {
		return inqty;
	}

	public void setInqty(Integer inqty) {
		this.inqty = inqty;
	}

	public Integer getOutqty() {
		return outqty;
	}

	public void setOutqty(Integer outqty) {
		this.outqty = outqty;
	}

   
}