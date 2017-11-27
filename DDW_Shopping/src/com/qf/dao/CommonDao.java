package com.qf.dao;

import java.util.List;

public interface CommonDao {
      List<String> getprovince();
      List<String> getcity(String province);
      List<String> getcounty(String city);
	
	
}
