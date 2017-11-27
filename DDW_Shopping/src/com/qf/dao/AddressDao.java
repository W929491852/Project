package com.qf.dao;

import java.util.List;

import com.qf.domain.Address;

public interface AddressDao {
         public boolean save(Address address);
         public boolean update(Address address);
         public List<Address> queryAll(int uid);
	}
