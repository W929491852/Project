package com.domain;

public class FlowCardDetail {
    private Integer id;

    private Temi temi;

    private Item item;

    private FlowCardMaster flowCardMaster;

    private Integer optQty;

    private Integer adjustQty;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    public Temi getTemi() {
		return temi;
	}
	public void setTemi(Temi temi) {
		this.temi = temi;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public FlowCardMaster getFlowCardMaster() {
		return flowCardMaster;
	}

	public void setFlowCardMaster(FlowCardMaster flowCardMaster) {
		this.flowCardMaster = flowCardMaster;
	}

	public Integer getOptQty() {
        return optQty;
    }

    public void setOptQty(Integer optQty) {
        this.optQty = optQty;
    }

    public Integer getAdjustQty() {
        return adjustQty;
    }

    public void setAdjustQty(Integer adjustQty) {
        this.adjustQty = adjustQty;
    }

}