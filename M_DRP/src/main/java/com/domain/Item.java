package com.domain;

public class Item {
    private Integer itemno;

    private String itemname;

    private String spec;

    private String pattern;

    private DataDict category;

    private DataDict unit;
    
    private String path;

    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
    }

	public DataDict getCategory() {
		return category;
	}

	public void setCategory(DataDict category) {
		this.category = category;
	}

	public DataDict getUnit() {
		return unit;
	}

	public void setUnit(DataDict unit) {
		this.unit = unit;
	}

   
}