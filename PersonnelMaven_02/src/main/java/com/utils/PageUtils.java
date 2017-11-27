package com.utils;

import com.domain.Page;

public class PageUtils {

	public static Page getPage(int pageIndex,int size) {
		Page page=new Page();
		page.setPageSize(3);
		page.setPageIndex(pageIndex);
//		int totle=size/page.getPageSize();
//		if((size%page.getPageSize())!=0) {
//			totle++;
//		}
//		page.setRecordCount(totle);
		page.setRecordCount(size);
		return page;
	}
}
