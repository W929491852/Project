package com.qf.service;

import java.util.List;

public interface CommonService {
	 List<String> getprovince();
     List<String> getcity(String province);
     List<String> getcounty(String city);
}
