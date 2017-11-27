package com.utils;

public class StringCheckEmpty {

	public static boolean checked(String...strs) {
		
		if(strs!=null) {
			for(int i=0;i<strs.length;i++) {
				if(strs[i]==null||"".equals(strs[i])) {
					return false;
				}
			}
		}else {
			return false;
		}
		return true;
	}
}
