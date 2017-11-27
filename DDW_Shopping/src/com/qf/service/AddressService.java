package com.qf.service;

import java.util.List;

import com.qf.domain.Address;

public interface AddressService {

	public boolean save(Address address);
    public boolean update(Address address);
    public List<Address> queryAll(int uid);
}
