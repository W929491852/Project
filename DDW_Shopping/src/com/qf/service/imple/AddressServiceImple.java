package com.qf.service.imple;

import java.util.List;

import com.qf.dao.AddressDao;
import com.qf.dao.imple.AddressDaoImple;
import com.qf.domain.Address;
import com.qf.service.AddressService;

public class AddressServiceImple implements AddressService{
        private AddressDao dao=new AddressDaoImple();
	@Override
	public boolean save(Address address) {
		// TODO Auto-generated method stub
		return dao.save(address);
	}

	@Override
	public boolean update(Address address) {
		// TODO Auto-generated method stub
		return dao.update(address);
	}

	@Override
	public List<Address> queryAll(int uid) {
		// TODO Auto-generated method stub
		return dao.queryAll(uid);
	}

}
