package com.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PageTag extends SimpleTagSupport{
	private String pageIndex;//当前是第几页
	private String pageSize;//每页显示多少条数据
	private String recordCount;//分页总数
	private String submitUrl;//url地址
	private String style;//样式
	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}
	public void setSubmitUrl(String submitUrl) {
		this.submitUrl = submitUrl;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("<div class='"+this.style+"'>");
		if(Integer.parseInt(this.pageIndex)>1) {
			int page=Integer.parseInt(this.pageIndex)-1;
			sb.append("<a href='"+this.submitUrl+"?pageIndex="+page+"'>上一页</a>");
		}
		sb.append("<span class='current'>"+this.pageIndex+"</span>");
		int totle=Integer.parseInt(this.recordCount)/Integer.parseInt(this.pageSize);
		if((Integer.parseInt(this.recordCount)%Integer.parseInt(this.pageSize))!=0) {
			totle++;
		}
		if(Integer.parseInt(this.pageIndex)<totle) {
			int page=Integer.parseInt(this.pageIndex)+1;
			sb.append("<a href='"+this.submitUrl+"?pageIndex="+page+"'>下一页</a>");
		}
		sb.append("跳转到<input type='text' id='skipIndex' size='1'><a href='javascript:skip()'>确定</a>");
		sb.append("总共<span class='disabled'>"+this.recordCount+"</span>条记录,当前显示<span class='disabled'>"+this.recordCount+"-"+this.pageIndex+"</span>条记录");
		sb.append("</div>");
		sb.append("<input type='hidden' value='"+this.submitUrl+"' id='url'/>");
		sb.append("<input type='hidden' value='"+totle+"' id='totle'/>");
		getJspContext().getOut().write(sb.toString());
	}
}
